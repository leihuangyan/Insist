package com.lhy.insist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
@EnableCircuitBreaker
@Slf4j
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);
    }

}
