package org.czy.example.collection;

import lombok.Data;

import java.util.List;

/**
 * @author chenzhiyuan
 * @date 2019/5/24
 * @Description
 */
@Data
public class Person {
    private String name;
    private Integer age;
    private boolean rich;
    private List<Car> carList;
}
