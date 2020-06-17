package com.lhy.insist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.EmpController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: EmpController
 */
@RestController
@Slf4j
public class EmpController{

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/vi/emp/{name}")
    public String info(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:{}" , serverPort,name);
        return String.format("端口:%s,得到结果:%s",serverPort,name);
    }
}
