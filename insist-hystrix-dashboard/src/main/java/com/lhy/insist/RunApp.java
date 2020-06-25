package com.lhy.insist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @name: DemoApplication
 * @author: LHY
 * @classPath: com.lhy.insist.EurekaApplication
 * @date: 2020/6/14 16:50
 * @Version: 1.0
 * @description: RunApp
 *
 * http://www.insist-cloud.com:7001/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);
    }

}
