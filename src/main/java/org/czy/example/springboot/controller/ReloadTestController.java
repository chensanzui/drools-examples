package org.czy.example.springboot.controller;

import org.czy.example.springboot.bean.Address;
import org.czy.example.springboot.bean.AddressCheckResult;
import org.czy.example.springboot.service.ReloadDroolsRulesService;
import org.czy.example.springboot.util.KieUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author chenzhiyuan
 * @date 2019/5/28
 * @Description
 */
@Controller
public class ReloadTestController {
    @Autowired
    private ReloadDroolsRulesService rules;

    @ResponseBody
    @RequestMapping("/reload/address")
    public String test(){
        KieSession kieSession = KieUtils.getKieSession();

        Address address = new Address();
        address.setPostcode("99425");

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }
        return "触发了" + ruleFiredCount + "条规则";

    }


    @ResponseBody
    @RequestMapping("/reload")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }
}
