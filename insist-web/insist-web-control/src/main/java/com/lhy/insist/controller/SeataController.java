package com.lhy.insist.controller;

import com.lhy.insist.service.SeataService;
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
    private SeataService seataService;


    @GetMapping(value="/v1/finance/seate1")
    @ApiOperation(value = "seate1",notes = "seate1")
    public String seate1() {
        return seataService.seate1();
    }


    @GetMapping(value="/v1/finance/seate2")
    @ApiOperation(value = "seate2",notes = "seate2")
    public String seate2() {
        return seataService.seate2();
    }
}



