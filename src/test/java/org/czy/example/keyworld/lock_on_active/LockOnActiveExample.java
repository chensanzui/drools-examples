package org.czy.example.keyworld.lock_on_active;

import org.czy.example.util.KieSessionUtil;
import org.czy.example.vo.Message;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
public class LockOnActiveExample {

    /**
     * 当在规则上使用ruleflow-group属性或agenda-group属性的时候，将lock-on-active 属性的值设置为true
     * 可以避免其他规则修改FACT对象导致规则的重新执行
     */
    @Test
    public void lockOnActive(){
        Message message = new Message();
        message.setStatus(Message.HELLO);
        KieSession kieSession = KieSessionUtil.getSession("LockOnActiveKS");
        kieSession.insert(message);
        kieSession.fireAllRules();
        Assert.assertEquals(10,message.getStatus());
        Assert.assertNull(message.getMessage());
    }
}
