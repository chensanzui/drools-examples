package org.czy.example.keyworld.ruleflow_group;

import org.czy.example.util.KieSessionUtil;
import org.czy.example.vo.Message;
import org.drools.core.common.InternalAgenda;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
public class RuleFlowGroupExample {

    /**
     * ruleflow-group属性的作用是将规则划分为一个个的组
     * 然后在规则流当中通过指定ruleflow-group属性的值，从而执行对应的规则
     */
    @Test
    public void ruleFlowGroup(){
        Message message = new Message();
        message.setStatus(Message.HELLO);
        KieSession kieSession = KieSessionUtil.getSession("RuleFlowGroupKS");
        kieSession.insert(message);
        ((InternalAgenda)kieSession.getAgenda()).activateRuleFlowGroup("group1");
        ((InternalAgenda)kieSession.getAgenda()).activateRuleFlowGroup("group2");
        kieSession.fireAllRules();
    }
}
