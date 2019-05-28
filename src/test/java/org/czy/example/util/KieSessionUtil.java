package org.czy.example.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
public class KieSessionUtil {
    public static KieSession getSession(String name){
        return KieServices.Factory.get().getKieClasspathContainer().newKieSession(name);
    }

    public static StatelessKieSession getStatelessKieSession(String name){
        return KieServices.Factory.get().getKieClasspathContainer().newStatelessKieSession(name);
    }

    public static void dispose(KieSession kieSession){
        if(kieSession != null) {
            kieSession.dispose();
        }
    }
}
