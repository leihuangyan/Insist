package com.lhy.insist.service;

import com.lhy.insist.service.fallback.DailyFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @name: FinanceService
 * @author: LHY
 * @classPath: com.lhy.insist.service.FinanceService
 * @date: 2020/6/21 02:01
 * @Version: 1.0
 * @description: TODO
 */
@Service
@FeignClient(value = "insist-service-daily6003",fallback = DailyFallbackService.class)
public interface DailyService {

    @GetMapping(value="/v1/daily/study/{name}")
     String study(@PathVariable(name = "name")String name);


    @GetMapping(value="/v1/daily/code/{name}")
     String code(@PathVariable(name = "name")String name);


    @GetMapping(value="/v1/daily/game/{name}")
     String game(@PathVariable(name = "name")String name);
}
