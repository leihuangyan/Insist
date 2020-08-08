package com.lhy.insist.api;

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
@FeignClient(value = "insist-service-emp6001")
public interface EmpWalletService {



    @GetMapping(value="/v1/emp/insert")
    String insert();
}
