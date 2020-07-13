package com.lhy.insist.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @name: CustomerBlockHandler
 * @author： LHY
 * @classPath: com.lhy.insist.hander.CustomerBlockHandler
 * @date: 2020/7/13 14:42
 * @Version: 1.0
 * @description: TODO
 */
public class CustomerBlockHandler {

    public static String handlerExceptionInfo(BlockException exception) {
        return  "按照客户自定义的Glogal info 全局异常处理 ---- 1";
    }

    public static String handlerExceptionTimeOut(BlockException exception) {
        return  "按照客户自定义的Glogal time out 全局异常处理 ---- 2";
    }
}
