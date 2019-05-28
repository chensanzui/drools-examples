package org.czy.example.keyworld.salience;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
public class SalienceExample {
    /**
     * salience属性的作用是指定规则的优先级，默认为0，规则随机
     * 数值越大优先级越高，越先执行。并且salience的值可以为0
     *
     */
    @Test
    public void salience(){
        KieSession kSession = KieSessionUtil.getSession("SalienceKS");
        kSession.fireAllRules();
    }
}
