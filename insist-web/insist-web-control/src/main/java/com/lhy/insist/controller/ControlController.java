package com.lhy.insist.controller;

import com.lhy.insist.HostConst;
import com.lhy.insist.service.DailyService;
import com.lhy.insist.service.FinanceService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class ControlController {

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


    @Autowired
    private DailyService dailyService;

    @GetMapping(value="/v1/daily/study/{name}")
    @ApiOperation(value = "study",notes = "String")
    @HystrixCommand
    public String study(@PathVariable(name = "name")String name) {
        int n = 10/0;
        return dailyService.study(name);
    }


    @HystrixCommand(fallbackMethod = "code_FallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping(value="/v1/daily/code/{name}")
    @ApiOperation(value = "code",notes = "String")
    public String code(@PathVariable(name = "name") String name) {
        int n = 10/0;
        return dailyService.code(name);
    }


    @HystrixCommand
    @GetMapping(value="/v1/daily/game/{name}")
    @ApiOperation(value = "game",notes = "String")
    public String daily(
            @ApiParam(value = "传入'下饭'多次 服务熔断，输入'nb'，正常处理。其他的服务降级")
            @PathVariable(name = "name")String name) {
        return dailyService.game(name);
    }

    public String code_FallbackMethod (String name){
        return String.format("web-control 指定降级，[%s]:你代码运行太慢了。。。",name);
    }

    public String global_FallbackMethod (){
        return String.format("web-control 全局降级处理。。。");
    }


    @Autowired
    private FinanceService financeService;

    @GetMapping(value="/vi/finance/{name}")
    @ApiOperation(value = "得到finance",notes = "String")
    public String finance(@PathVariable(name = "name")String name) {
//        return restTemplate.getForEntity(HostConst.FINANCE_URL + "/vi/finance/{0}", String.class,name);
        return financeService.info(name);
    }


    @GetMapping(value="/vi/finance/timeout/{val}")
    @ApiOperation(value = "测试超时",notes = "String")
    public String timeout(@PathVariable(name = "val")String val) {
        return financeService.timeout(val);
    }
}



