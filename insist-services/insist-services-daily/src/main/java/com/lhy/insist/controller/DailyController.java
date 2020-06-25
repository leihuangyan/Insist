package com.lhy.insist.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.DailyController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: DailyController
 */
@RestController
@Slf4j
public class DailyController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/v1/daily/study/{name}")
    public String info(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【{}:日常->开始学习spring-cloud 】" , serverPort,name);
        return String.format("端口:%s,得到结果:【%s:日常->开始学习spring-cloud 】",serverPort,name);
    }

    @GetMapping(value="/v1/daily/code/{name}")
    public String info2(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【{}:日常->开始编码spring-cloud   】" , serverPort,name);
        log.info("好垃圾啊。。。运行这么慢");
        try {
            Thread.sleep(3000);
            log.info("执行结束");
        } catch (InterruptedException e) {
            log.error("超时啦。。。。。。啊啊啊啊");
            e.printStackTrace();
        }
        return String.format("端口:%s,得到结果:【%s:日常->开始编码spring-cloud 】",serverPort,name);
    }


    @GetMapping(value="/v1/daily/game/{name}")
    public String info3(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【{}:日常->开始游戏 】" , serverPort,name);
        return String.format("端口:%s,得到结果:【%s:日常->开始游戏 】",serverPort,name);
    }
}
