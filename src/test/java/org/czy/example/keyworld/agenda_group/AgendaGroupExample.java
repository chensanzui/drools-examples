package org.czy.example.keyworld.agenda_group;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
public class AgendaGroupExample {

    /**
     *AgendaGroup的作用是用来在Agenda基础上对规则进行再次分组。通过它可以将规则分为若干个Agenda Group。
     * 引擎在调用设置了agenda-group属性的规则时需要显示的指定某个Agenda Group得到Focus（焦点）
     * 否则将不执行该Agenda Group当中的规则
     * 与ruleflow_group的区别是，ruleflow是对应一个规则，agendaGroup是针对一组
     *  auto-focus参数为true默认开启焦点
     */
    @Test
    public void agendaGroup(){
        KieSession kieSession = KieSessionUtil.getSession("AgendaGroupKS");
        //如果去掉则规则不执行
        kieSession.getAgenda().getAgendaGroup("demo").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
