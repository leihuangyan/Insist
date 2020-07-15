package com.lhy.insist.database.master.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lhy.insist.database.master.enums.fill.InsertFillEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @name: MyMetaObjectHandler
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.handler.MyMetaObjectHandler
 * @date: 2020/7/13 21:27
 * @Version: 1.0
 * @description: 填充器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始 insert 填充 ....");
        for (InsertFillEnum fillEnum : InsertFillEnum.values()) {
            final String column = fillEnum.getColumn();
            final Object val = fillEnum.getVal();
            log.info("---> column:{}  <--> val:{}",column,val);
            this.setFieldValByName(column, val, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始 update 填充 ....");
        //for (UpdateFillEnum fillEnum : UpdateFillEnum.values()) {
        //    final String column = fillEnum.getColumn();
        //    final Object val = fillEnum.getVal();
        //    log.info("---> column:{}  <--> val:{}",column,val);
        //    this.setFieldValByName(column, val, metaObject);
        //}
    }
}
