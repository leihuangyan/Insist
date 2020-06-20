package com.lhy.myrole;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @name: MySelfRule
 * @author: LHY
 * @classPath: com.lhy.myrole.MySelfRule
 * @date: 2020/6/21 01:22
 * @Version: 1.0
 * @description: 自定义Ribbon负载均衡规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RandomRule();
    }

}
