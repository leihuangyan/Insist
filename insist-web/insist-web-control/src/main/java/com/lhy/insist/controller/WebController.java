package com.lhy.insist.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class WebController {

    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/obj")
    @ApiOperation(value = "响应泛型类型为String类型",notes = "String")
    public String obj(@ApiParam(value = "参数-name",required = true,example = "example") String param){
        log.info("收到参数:{}",param);
        return "knife4j-spring-boot-starter 测试成功!!!";
    }
}



