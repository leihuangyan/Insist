package com.lhy.insist.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lhy.insist.hander.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
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

    
    @GetMapping(value="/v1/finance/seate1")
    @SentinelResource(value = "seate1",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExceptionError"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionError"
    )
    public String seate1() {
        return "测试 seate1";
    }


    @GetMapping(value="/v1/finance/seate2")
    @SentinelResource(value = "seate2",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExceptionError"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionError"
    )
    public String seate2() {
        return "测试 seate2";
    }
}
