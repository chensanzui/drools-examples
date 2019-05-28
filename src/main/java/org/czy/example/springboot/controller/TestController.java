package org.czy.example.springboot.controller;

import org.czy.example.springboot.bean.Address;
import org.czy.example.springboot.bean.AddressCheckResult;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenzhiyuan
 * @date 2019/5/23
 * @Description
 */
@RestController
public class TestController {
    @Resource
    private KieSession kieSession;

    @RequestMapping("/address")
    public String test(){
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
}
