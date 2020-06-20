package com.lhy.insist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.FinanceController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: FinanceController
 */
@RestController
@Slf4j
public class FinanceController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/vi/finance/{name}")
    public String info(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【余额:{} -1000】" , serverPort,name);
        return String.format("端口:%s,得到结果:【余额:%s -1000】",serverPort,name);
    }


    @GetMapping(value="/vi/finance/timeout/{val}")
    public String timeout(@PathVariable(name = "val")String val) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        }
        return String.format("端口:%s,测试超时返回",serverPort);
    }
}
