package com.lhy.insist.database.master.base;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;


/**
 * @name: SuperController
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.base.SuperController
 * @date: 2020/7/13 21:26
 * @Version: 1.0
 * @description: 父类 SuperController
 */
public class SuperController<T> extends R<T> {

    //========================== 成功实例 ==========================


    public  SuperController<T> success(){
        return success(ApiErrorCode.SUCCESS);
    }

    public  SuperController<T> success(T data){
        return success(ApiErrorCode.SUCCESS, data);
    }


    public  SuperController<T> success(ApiErrorCode apiErrorCode){
        return success(apiErrorCode,null);
    }

    public  SuperController<T> success(ApiErrorCode apiErrorCode, T data){
        return builder(apiErrorCode, data, apiErrorCode.getMsg());
    }

    public  SuperController<T> success(String msg){
        return builder(ApiErrorCode.SUCCESS, null,msg);
    }

    //========================== 失败实例 ==========================


    public  SuperController<T> failure(){
        return failure(ApiErrorCode.FAILED);
    }

    public  SuperController<T> failure(T data){
        return failure(ApiErrorCode.FAILED, data);
    }

    public  SuperController<T> failure(ApiErrorCode apiErrorCode){
        return failure(apiErrorCode,null);
    }


    public  SuperController<T> failure(ApiErrorCode apiErrorCode, T data){
        return builder(apiErrorCode, data, apiErrorCode.getMsg());
    }

    public  SuperController<T> failure(String msg){
        return builder(ApiErrorCode.FAILED, null,msg);
    }

    //========================== 自定义初始化 ==========================


    public  SuperController<T> builder(ApiErrorCode apiErrorCode, T data, String msg){
        super.setCode(apiErrorCode.getCode()).setData(data).setMsg(msg);
        return this;
    }

    //========================== 异常 ==========================

    public  SuperController<T> error(Exception e){
        return builder(ApiErrorCode.FAILED,
                this.getData(),
                String.format("系统异常:--->%s",e.getMessage()));
    }
}

