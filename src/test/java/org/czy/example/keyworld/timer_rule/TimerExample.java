package org.czy.example.keyworld.timer_rule;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
public class TimerExample {
    /**
     *
     */
    @Test
    public void timer() throws InterruptedException {
        KieSession kieSession = KieSessionUtil.getSession("TimerRuleKS");
        ResultEvent event = new ResultEvent();
        kieSession.setGlobal("event", event);
        Server server = new Server(1);
        //Drools现在支持fireUntilHalt()功能，它以一种被动模式启动引擎，在那儿规则会被连续引发，直到调用了halt()。
        // 这尤其对CEP（complex event processing）场景有用，CEP场景需要俗称的“活动查询”
        new Thread(()-> {
            kieSession.fireUntilHalt();
        }
        ).start();
        FactHandle serverHandle = kieSession.insert(server);
        for (int i = 8; i <= 15; i++) {
            Thread.sleep(2000);
            server.setTimes(++i);
            kieSession.update(serverHandle, server);
        }
        Thread.sleep(3000);
        kieSession.halt();
        System.out.println(event.getEvents());

    }
}
