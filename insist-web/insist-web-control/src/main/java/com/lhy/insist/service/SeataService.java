package com.lhy.insist.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @name: FinanceService
 * @author: LHY
 * @classPath: com.lhy.insist.service.FinanceService
 * @date: 2020/6/21 02:05
 * @Version: 1.0
 * @description: TODO
 */
@Service
@FeignClient(value = "insist-service-finance6002")
public interface SeataService {


    @GetMapping(value="/v1/finance/seate1")
    String seate1() ;


    @GetMapping(value="/v1/finance/seate2")
    String seate2();
}
