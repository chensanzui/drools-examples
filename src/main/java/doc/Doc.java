package doc;

import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.internal.conf.MultithreadEvaluationOption;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
public class Doc {

    /**
     * 开启drools多线程
     * drools的多线程还是实现性质的
     */
    public void threadDrools(){
        KieServices ks = KieServices.Factory.get();
        KieBaseConfiguration kieBaseConf = ks.newKieBaseConfiguration();
        kieBaseConf.setOption(MultithreadEvaluationOption.YES);
       // KieBase kieBase = KieContainer.newKieBase(kieBaseConf);
        // 或者通过系统属性:drools.multithreadEvaluation = true
    }

    /**
     * kmoudle的作用
     * KIE 使用默认值来最小化配置量。空的 kmodule.xml 是最简单的配置。
     * 必须始 终有一个 kmodule.xml 文件，即使是空的，因为它用于发现 JAR 及其内容。
     * Kie 项目具有普通 Maven 项目的结构，其唯一的特点是包含一个 kmodule.xml
     * 文件，以声明方式定义可以从中创建的KieBase和KieSession。此文件必须放在 Maven 项目的 resources / META-INF 文件夹中，
     * 而所有其他 Kie 工件(如 DRL 或 Excel 文件)必须存储在 resources 文件夹或其下的任何其他子文件夹中。
     *由于已为所有配置方面提供了有意义的默认值，因此最简单的 kmodule.xml 文 件只能包含空的 kmodule 标记
     */

    /**
     * `KieServices`是可以访问所有 Kie 构建和运行时设施的接口
     */

    /**
     * KieBase是所有应用程序知识定义的存储库。它将包含规则，流程，函数和类型模型。它KieBase本身不包含数据
     */

    /**
     * KieSession存储和执行运行时数据
     * 需要注意的是，由于 KSession2_1 和 KSession2_2 有两种不同的类型(第一种StatelessKieSession kieSession2 =
     kContainer.newStatelessKieSession("KSession2_2");
     是有状态的，而第二种是无状态的)，因此必须
     KieContainer
     根据它们声明的类
     型调用 2 种不同的方法
     */
}