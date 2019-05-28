package org.czy.example.keyworld.timer_rule;

import lombok.Data;

/**
 * @author chenzhiyuan
 * @date 2019/5/27
 * @Description
 */
@Data
public class Server {
    private int times;
    public Server(){

    }
    public Server(int times) {
        this.times = times;
    }
}
