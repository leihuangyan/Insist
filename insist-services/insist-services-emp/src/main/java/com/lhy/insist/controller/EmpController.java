package com.lhy.insist.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.insist.database.master.model.user.entity.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.EmpController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: EmpController
 */
@RestController
@Slf4j
public class EmpController{

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/vi/emp/{name}")
    public String info(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:{}" , serverPort,name);
        return String.format("端口:%s,得到结果:%s",serverPort,name);
    }

    @GetMapping(value="/vi/emp/users")
    public String users() {
        log.info("开始查询。。。。");

        IPage<UserPO> page = new Page<>();

        page.setPages(1).setSize(10);

        IPage<UserPO> userPOIPage = new UserPO().selectPage(page, null);

        String jsonStr = JSONUtil.toJsonStr(userPOIPage);

        log.info("获取到查询结果:{}",jsonStr);
        return jsonStr;
    }
}
