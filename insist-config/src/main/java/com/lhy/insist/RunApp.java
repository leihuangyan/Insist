package com.lhy.insist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @name: RunApp
 * @author： LHY
 * @classPath: com.lhy.insist.RunApp
 * @date: 2020/6/28 11:15
 * @Version: 1.0
 * @description: RunApp
 */
@SpringBootApplication
@EnableConfigServer
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class,args);
    }
}