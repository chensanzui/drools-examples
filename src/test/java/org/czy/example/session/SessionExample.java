package org.czy.example.session;

import org.czy.example.util.KieSessionUtil;
import org.kie.api.runtime.StatelessKieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/24
 * @Description
 */
public class SessionExample {

    public void session(){
        StatelessKieSession statelessKieSession =KieSessionUtil.getStatelessKieSession("");
    }
}
