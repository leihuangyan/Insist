package com.lhy.insist.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @name: CustomerBlockHandler
 * @author： LHY
 * @classPath: com.lhy.insist.hander.CustomerBlockHandler
 * @date: 2020/7/13 14:42
 * @Version: 1.0
 * @description: TODO
 */
@Slf4j
public class CustomerBlockHandler {

    public static String handlerExceptionInfo(@PathVariable(name = "name")String name,BlockException exception) {
        log.info("按照自定义的Glogal info 全局流控处理param:{},->{}",name,exception.toString());
        return  "按照自定义的Glogal info 全局流控处理 ---- 1";
    }

    public static String handlerExceptionError(@PathVariable(name = "val")String val,BlockException exception) {
        log.info("按照自定义的Glogal timeout 全局流控处理param:{},->{}",val,exception.toString());
        return  "按照自定义的Glogal timeout 全局流控处理 ---- 2";
    }

    public static String errorExceptionInfo(@PathVariable(name = "name")String name,Throwable exception) {
        log.info("按照自定义的Glogal info 全局异常处理param:{},->{}",name,exception.toString());
        return  "按照自定义的Glogal info 全局异常处理 ---- 1";
    }

    public static String errorExceptionError(@PathVariable(name = "val")String val,Throwable exception) {
        log.info("按照自定义的Glogal timeout 全局异常处理param:{},->{}",val,exception.toString());
        return  "按照自定义的Glogal timeout 全局异常处理 ---- 2";
    }
}
