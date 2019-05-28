package org.czy.example.helloworld;

import org.czy.example.vo.Message;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
public class HelloWorldExample {

    @Test
    public void helloWorld(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieContainer.newKieSession("HelloWorldKS");
        Message message = new Message();
        message.setStatus(Message.HELLO);
        ks.insert(message);
        ks.fireAllRules();
        Assert.assertEquals(Message.HELLO_MESSAGE,message.getMessage());
    }
}
