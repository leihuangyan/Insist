package com.lhy.insist.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lhy.insist.hander.CustomerBlockHandler;
import com.lhy.insist.service.EmpWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @name: SeateController
 * @author: LHY
 * @classPath: com.lhy.insist.controller.SeateController
 * @date: 2020/7/27 15:53
 * @Version: 1.0
 * @description: TODO
 */
@RestController
@Slf4j
public class SeateController {

    @Autowired
    private EmpWalletService empWalletService;

    @GetMapping(value="/v1/emp/insert")
    @SentinelResource(value = "emp-insert",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExceptionError"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionError"
    )
    public String insert() {
        log.info("emp 开始插入");
        log.info("emp 模拟超时--->");

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return empWalletService.insert();
    }
}
