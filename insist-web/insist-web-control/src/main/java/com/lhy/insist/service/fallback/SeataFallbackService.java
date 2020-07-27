package com.lhy.insist.service.fallback;

import com.lhy.insist.service.SeataService;
import org.springframework.stereotype.Component;

/**
 * @name: SeataFallbackService
 * @author: LHY
 * @classPath: com.lhy.insist.service.fallback.SeataFallbackService
 * @date: 2020/7/27 16:44
 * @Version: 1.0
 * @description: TODO
 */
@Component
public class SeataFallbackService implements SeataService {


    @Override
    public String seate1() {
        return "-------->seate1 回调";
    }

    @Override
    public String seate2() {
        return "-------->seate2 回调";
    }
}
