package com.lhy.insist.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: FeignConfig
 * @author: LHY
 * @classPath: com.lhy.insist.config.FeignConfig
 * @date: 2020/6/21 02:01
 * @Version: 1.0
 * @description: FeignConfig
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }
}
