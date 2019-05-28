package org.czy.example.collection;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzhiyuan
 * @date 2019/5/24
 * @Description
 */
public class CollectionExample {
    @Test
    public void collect(){
        KieSession ks = KieSessionUtil.getSession("CollectionKS");
        Person person = new Person();
        Car car  = new Car();
        car.setName("保时捷");
        Car car2  = new Car();
        car.setName("宝马");
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);
        person.setCarList(carList);
        ks.insert(person);
        ks.insert(carList);
        ks.fireAllRules();
    }
}
