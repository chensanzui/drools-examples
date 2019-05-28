package org.czy.example.keyworld.activation_group;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
public class ActivationGroupExample {
    /**
     * activation-group的作用是具有相同activation-group 属性的规则中只要有一个被执行，其它的规则都不再执行
     */
    @Test
    public void activationGroup(){
        KieSession kieSession = KieSessionUtil.getSession("ActivationGroupKS");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
