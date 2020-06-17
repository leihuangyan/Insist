package com.lhy.insist.controller;

import com.lhy.insist.hosts.HostConst;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @name: WebController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.WebController
 * @date: 2020/6/14 17:46
 * @Version: 1.0
 * @description: WebController
 */
@Api(value = "响应自定义",tags = "响应自定义")
@RestController
@RequestMapping("/api/response")
@Slf4j
public class AppController {

    @Resource
    private RestTemplate restTemplate;

    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/v1/test")
    @ApiOperation(value = "响应泛型类型为String类型",notes = "String")
    public String obj(@ApiParam(value = "参数-name",required = true,example = "example") String param){
        log.info("收到参数:{}",param);
        return "knife4j-spring-boot-starter 测试成功!!!";
    }


    @GetMapping(value="/vi/emp/{name}")
    @ApiOperation(value = "得到emp",notes = "String")
    public ResponseEntity<String> emp(@PathVariable(name = "name")String name) {
        return restTemplate.getForEntity(HostConst.EMP_URL + "/vi/emp/{0}", String.class,name);
    }

    @GetMapping(value="/vi/daily/{name}")
    @ApiOperation(value = "得到Daily",notes = "String")
    public ResponseEntity<String> daily(@PathVariable(name = "name")String name) {
        return restTemplate.getForEntity(HostConst.DAILY_URL + "/vi/daily/{0}", String.class,name);
    }


    @GetMapping(value="/vi/finance/{name}")
    @ApiOperation(value = "得到finance",notes = "String")
    public ResponseEntity<String> finance(@PathVariable(name = "name")String name) {
        return restTemplate.getForEntity(HostConst.FINANCE_URL + "/vi/finance/{0}", String.class,name);
    }
}



