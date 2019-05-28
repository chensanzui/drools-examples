package org.czy.example.vo;

import lombok.Data;

/**
 * @author chenzhiyuan
 * @date 2019/5/22
 * @Description
 */
@Data
public class Message {

    public static final int HELLO = 0;
    public static final int GOODBYE = 1;
    public static final String HELLO_MESSAGE = "Hello";
    public static final String GOODBYE_MESSAGE = "Goodbye";

    private String message;
    private int status;
}
