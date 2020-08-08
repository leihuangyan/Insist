package com.lhy.insist.controller;

import com.lhy.insist.service.SeataFinanceWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: SeataController
 * @author: LHY
 * @classPath: com.lhy.insist.controller.SeataController
 * @date: 2020/7/27 15:54
 * @Version: 1.0
 */
@Api(value = "Seata",tags = "Seata")
@RestController
@RequestMapping("/api/seata")
@Slf4j
public class SeataController {

    @Autowired
    private SeataFinanceWalletService seataFinanceWalletService;




    @GetMapping(value="/v1/seate/wallet/insert")
    @ApiOperation(value = "insert",notes = "insert")
    public String insert() {
        return seataFinanceWalletService.insert();
    }



    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
//    @GetMapping("/snowflake")
//    public String getIDBySnowflake() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 20; i++) {
//            threadPool.submit(() -> {
//                System.out.println(idGeneratorSnowflake.snowflakeId());
//            });
//        }
//        threadPool.shutdown();
//        return "hello snowflake";
//    }
}



