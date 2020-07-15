package com.lhy.insist.database.master.enums.fill;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @name: InsertFillEnum
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.enums.fill.InsertFillEnum
 * @date: 2020/7/13 21:27
 * @Version: 1.0
 * @description: insert 填充枚举
 */
@Getter
@AllArgsConstructor
public enum InsertFillEnum {
    COLUMN_STATE("state",0),
    COLUMN_CREATE_TIME("createTime",LocalDateTime.now());

    private String column;
    private Object val;

}
