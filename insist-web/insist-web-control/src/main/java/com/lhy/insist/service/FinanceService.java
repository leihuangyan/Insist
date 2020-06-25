package com.lhy.insist.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @name: FinanceService
 * @author: LHY
 * @classPath: com.lhy.insist.service.FinanceService
 * @date: 2020/6/21 02:05
 * @Version: 1.0
 * @description: TODO
 */
@Service
@FeignClient(value = "INSIST-SERVICE-FINANCE6002")
public interface FinanceService {


    @GetMapping(value="/vi/finance/{name}")
    String info(@PathVariable(name = "name")String name) ;


    @GetMapping(value="/vi/finance/timeout/{val}")
    String timeout(@PathVariable(name = "val")String val);
}
