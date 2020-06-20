package com.lhy.insist;

import com.lhy.myrole.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @name: DemoApplication
 * @author: LHY
 * @classPath: com.lhy.insist.EurekaApplication
 * @date: 2020/6/14 16:50
 * @Version: 1.0
 * @description: EurekaApplication
 * RunApp Ribbon实现  客户端可无需注册
 */
@SpringBootApplication
@EnableDiscoveryClient
//定义Ribbon 规则为自定义规则
@RibbonClient(name = "INSIST-SERVICE-EMP6001",configuration = MySelfRule.class)
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);
    }

}
