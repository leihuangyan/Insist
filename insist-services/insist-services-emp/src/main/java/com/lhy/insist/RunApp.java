package com.lhy.insist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @name: DemoApplication
 * @author: LHY
 * @classPath: com.lhy.insist.EurekaApplication
 * @date: 2020/6/14 16:50
 * @Version: 1.0
 * @description: RunApp
 */
@SpringBootApplication
@EnableDiscoveryClient
public  class RunApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(RunApp.class, args);
        while(true) {
            String configInfo = applicationContext.getEnvironment().getProperty("config.info");
            //获取当前部署的环境
            String currentEnv = applicationContext.getEnvironment().getProperty("current.env");
            System.err.println("in "+currentEnv+" enviroment; "+"config info :" + configInfo + ";");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
