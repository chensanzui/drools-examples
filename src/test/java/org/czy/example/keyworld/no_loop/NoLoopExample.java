package org.czy.example.keyworld.no_loop;

import org.czy.example.util.KieSessionUtil;
import org.czy.example.vo.Message;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 *
 *
 */
public class NoLoopExample  {

    /**
     * no-loop 定义当前规则是否可以循环执行，
     * 默认false，只要满足条件便可以无限执行
     *
     */
    @Test
    public void noLoop(){
       KieSession kieSession = KieSessionUtil.getSession("NoLoopKS");
       Message message = new Message();
       message.setStatus(Message.HELLO);
       kieSession.insert(message);
       kieSession.fireAllRules();
       Assert.assertEquals(10,message.getStatus());
    }
}
