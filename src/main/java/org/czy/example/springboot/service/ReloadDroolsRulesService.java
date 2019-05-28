package org.czy.example.springboot.service;

import org.czy.example.springboot.util.KieUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author chenzhiyuan
 * @date 2019/5/28
 * @Description
 */
@Service
public class ReloadDroolsRulesService {
    public void reload() throws UnsupportedEncodingException {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/temp.drl", loadRules());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }

        KieUtils.setKieContainer(kieServices.newKieContainer(getKieServices().getRepository().getDefaultReleaseId()));
        System.out.println("新规则重载成功");
    }

    public String loadRules() {
        // 从数据库加载的规则
        return "package plausibcheck.adress\n\n import org.czy.example.springboot.bean.Address;\n import org.czy.example.springboot.bean.AddressCheckResult;\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";

    }
    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }

    public static void main(String[] args) {
        System.out.println(new ReloadDroolsRulesService().loadRules());
    }


}
