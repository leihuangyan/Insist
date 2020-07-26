package com.lhy.insist.controller;

import cn.hutool.json.JSONUtil;
import com.lhy.insist.database.master.model.user.entity.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @name: TestController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.TestController
 * @date: 2020/7/24 17:17
 * @Version: 1.0
 * @description: TODO
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping(value="/users")
    public String users() {
        log.info("开始查询。。。。");
        List<UserPO> userPOS = new UserPO().selectAll();
        log.info("获取到查询结果:{}",userPOS);
        return JSONUtil.toJsonStr(userPOS);
    }
}
