package com.lhy.insist.service.fallback;

import com.lhy.insist.service.DailyService;
import org.springframework.stereotype.Component;

/**
 * @name: FinanceService
 * @author: LHY
 * @classPath: com.lhy.insist.service.FinanceService
 * @date: 2020/6/21 02:01
 * @Version: 1.0
 * @description: TODO
 */
@Component
public class DailyFallbackService  implements DailyService {

    @Override
    public String study(String name) {
        return String.format("web-control 接口降级，[%s]:你学知识太慢了。。。",name);
    }

    @Override
    public String code(String name) {
        return String.format("web-control 接口降级，[%s]:你代码运行太慢了啊。。。",name);
    }

    @Override
    public String game(String name) {
        return String.format("web-control 接口降级，[%s]:你玩游戏太菜了。。。",name);
    }
}
