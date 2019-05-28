package org.czy.example.keyworld.date_effective;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
public class DateEffectiveExample {
    /**
     * date-effective的作用是只有当系统时间大于等于date-effective设置的时间值时，规则才会触发执行，
     * 否则执行将不执行。
     * date-expires与date-effective相反
     */
    @Test
    public void dateEffective(){
        //设置drools日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        KieSession kieSession = KieSessionUtil.getSession("DateEffectiveKS");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
