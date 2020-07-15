package com.lhy.insist.database.master.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @name: StateEnum
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.enums.StateEnum
 * @date: 2020/7/13 21:27
 * @Version: 1.0
 * @description: 状态枚举
 */
@Getter
@AllArgsConstructor
public enum StateEnum {
    /**
     * NORMAL 正常
     * ABNORMAL 异常
     */
    NORMAL(0,true),
    ABNORMAL(1,false);

    /**
     *  EnumValue 标记数据库存的值是code
     */
    @EnumValue
    private Integer code;

    private Boolean state;
}
