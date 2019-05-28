package org.czy.example.springboot.bean;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author chenzhiyuan
 * @date 2019/5/23
 * @Description
 */
@Data
public class Address {
    private String postcode;

    private String street;

    private String state;
    private static final String RULES_PATH ="rules/";



    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources =resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
        for (Resource r:resources) {
            String pathName  = r.getURI().getPath().substring(r.getURI().getPath().indexOf("classes")+"classes".length());
            System.out.println(pathName);
            System.out.println("getFilename----"+r.getFilename());
            System.out.println("getParent----"+r.getFile().getParent());
            System.out.println("getURI----"+r.getURI());
            System.out.println("getURL----"+r.getURL());
        }
        System.out.println(resources.length);

    }
}
