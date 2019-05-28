package org.czy.example.springboot.util;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author chenzhiyuan
 * @date 2019/5/28
 * @Description
 */
public class KieUtils {
    private static KieContainer kieContainer;

    private static KieSession kieSession;

    public static KieContainer getKieContainer() {
        return kieContainer;
    }

    public static void setKieContainer(KieContainer kieContainer) {
        KieUtils.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession();
    }

    public static KieSession getKieSession() {
        return kieSession;
    }

    public static void setKieSession(KieSession kieSession) {
        KieUtils.kieSession = kieSession;
    }

}
