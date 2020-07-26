package com.lhy.insist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @name: DemoApplication
 * @author: LHY
 * @classPath: com.lhy.insist.EurekaApplication
 * @date: 2020/6/14 16:50
 * @Version: 1.0
 * @description: RunApp
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public  class RunApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(RunApp.class, args);
//        while(true) {
//            String springDatasourceUrl = applicationContext.getEnvironment().getProperty("spring.datasource.url");
//            log.info("spring.datasource.url-->{}",springDatasourceUrl);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
