package com.lhy.insist.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.insist.database.master.model.user.entity.UserPO;
import com.lhy.insist.hander.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.FinanceController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: FinanceController
 */
@RestController
@Slf4j
public class FinanceController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/vi/finance/{name}")
    @SentinelResource(value = "info",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerExceptionInfo"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionInfo"
    )
    public String info(@PathVariable(name = "name")String name) {
        log.info("开始查询,端口:{},得到结果:【余额:{} -1000】" , serverPort,name);
        IPage<UserPO> page = new Page<>();

        page.setPages(1).setSize(10);

        IPage<UserPO> userPOIPage = new UserPO().selectPage(page, null);

        String jsonStr = JSONUtil.toJsonStr(userPOIPage);
        return String.format("端口:%s,得到结果:【余额:%s -1000】数据:%s",serverPort,name,jsonStr);
    }


    @GetMapping(value="/vi/finance/error/{val}")
    @SentinelResource(value = "error",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExceptionError"
            , fallbackClass = CustomerBlockHandler.class,fallback = "errorExceptionError"
    )
    public String timeout(@PathVariable(name = "val")String val) {
        log.info("进入/vi/finance/error。。。");
        log.info("结束/vi/finance/error。。。{}",Integer.parseInt(val));
        return String.format("端口:%s,测试超时返回",serverPort);
    }
}
