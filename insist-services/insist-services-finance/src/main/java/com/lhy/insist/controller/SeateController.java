package com.lhy.insist.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lhy.insist.hander.CustomerBlockHandler;
import com.lhy.insist.service.FinanceWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private FinanceWalletService financeWalletService;

    @GetMapping(value="/v1/finance/insert")
    @SentinelResource(value = "finance-insert",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExceptionError"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionError"
    )
    public String insert() {
        log.info("finance 开始插入");
        return financeWalletService.insert();
    }


}
