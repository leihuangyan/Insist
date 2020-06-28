package com.lhy.insist.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: EmpController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.DailyController
 * @date: 2020/6/17 09:15
 * @Version: 1.0
 * @description: DailyController
 */
@RestController
@Slf4j
public class DailyController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 因为config仓库以rest形式暴露，所以所有客户端都可以通过config服务端访问到github上对应的文件信息
     */
    @Value("${config.info}")
    private String configInfo;


    @GetMapping(value="/v1/daily/study/{name}")
    public String study(@PathVariable(name = "name")String name) {
        log.info("得到配置:configInfo->{},serverPort:{}",configInfo,serverPort);
        log.info("端口:{},得到结果:【{}:日常->开始学习spring-cloud 】" , serverPort,name);
        return String.format("端口:%s,得到结果:【%s:日常->开始学习spring-cloud 】",serverPort,name);
    }

    @GetMapping(value="/v1/daily/code/{name}")
    public String code(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【{}:日常->开始编码spring-cloud   】" , serverPort,name);
        return String.format("端口:%s,得到结果:【%s:日常->开始编码spring-cloud 】",serverPort,name);
    }


    // 服务熔断
    @HystrixCommand(fallbackMethod = "game_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    @GetMapping(value="/v1/daily/game/{name}")
    public String game(@PathVariable(name = "name")String name) {
        log.info("端口:{},得到结果:【{}:日常->开始游戏 】" , serverPort,name);
        log.info("好垃圾啊。。。玩的这么菜");
        try {
            if("下饭".equals(name)){
                int n = 10/0;
            }else if("nb".equals(name)){
                return String.format("端口:%s,得到结果:【%s:日常->玩游戏老子天下第一 】",serverPort,name);
            }else {
                Thread.sleep(3000);
            }
            log.info("游戏结束 0-8");
        } catch (InterruptedException e) {
            log.error("【异常处理】输啦吧 菜逼。。。");
        }
        return String.format("端口:%s,得到结果:【%s:日常->开始游戏 】",serverPort,name);
    }


    public String game_fallback(String game){
        return "菜逼，没星星了吧";
    }


}
