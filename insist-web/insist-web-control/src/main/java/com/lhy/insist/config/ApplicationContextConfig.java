package com.lhy.insist.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @name: ApplicationContextConfig
 * @author： LHY
 * @classPath: com.lhy.insist.resp.ApplicationContextConfig
 * @date: 2020/6/17 09:45
 * @Version: 1.0
 * @description: RestTemplate
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return  new RestTemplate();
    }
}

