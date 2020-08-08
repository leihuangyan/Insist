package com.lhy.insist.service.fallback;

import com.lhy.insist.service.SeataFinanceWalletService;
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
public class SeataFinanceWalletFallbackService implements SeataFinanceWalletService {

    @Override
    public String insert() {
         return "-------->seate insert 回调";
    }


}
