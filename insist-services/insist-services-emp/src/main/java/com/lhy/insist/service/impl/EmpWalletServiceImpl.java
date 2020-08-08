package com.lhy.insist.service.impl;

import com.lhy.insist.database.master.enums.StateEnum;
import com.lhy.insist.database.master.model.wallet.entity.WalletPO;
import com.lhy.insist.service.EmpWalletService;
import com.lhy.insist.snowflake.IdGeneratorSnowflake;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @name: EmpServiceImpl
 * @author： LHY
 * @classPath: com.lhy.insist.service.impl.EmpServiceImpl
 * @date: 2020/8/9 00:01
 * @Version: 1.0
 * @description: TODO
 */
@Service
public class EmpWalletServiceImpl implements EmpWalletService {



    @Override
    public String insert() {
        WalletPO walletPO = new WalletPO();
        walletPO.setId(String.valueOf(IdGeneratorSnowflake.snowflakeId()));
        walletPO.setName("测试seate emp");
        walletPO.setMoney(new BigDecimal("200"));
        walletPO.setFill1("fill1");
        walletPO.setFill2("fill2");
        walletPO.setVersion(1L);
        walletPO.setCreateTime(LocalDateTime.now());
        walletPO.setCreateUser("emp");
        walletPO.setUpdateTime(LocalDateTime.now());
        walletPO.setUpdateUser("emp");
        walletPO.setFlag(StateEnum.NORMAL);
        boolean insert = walletPO.insert();
        return "emp 插入"+insert;
    }
}
