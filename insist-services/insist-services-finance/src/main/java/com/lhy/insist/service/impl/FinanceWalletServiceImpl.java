package com.lhy.insist.service.impl;

import com.lhy.insist.api.EmpWalletService;
import com.lhy.insist.database.master.enums.StateEnum;
import com.lhy.insist.database.master.model.wallet.entity.WalletPO;
import com.lhy.insist.service.FinanceWalletService;
import com.lhy.insist.snowflake.IdGeneratorSnowflake;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Service
public class FinanceWalletServiceImpl implements FinanceWalletService {


    @Autowired
    private EmpWalletService empWalletService;

    @GlobalTransactional(name = "lhy-create-order",rollbackFor = Exception.class)
    @Override
    public String insert() {
        WalletPO walletPO = new WalletPO();

        walletPO.setId(String.valueOf(IdGeneratorSnowflake.snowflakeId()));
        walletPO.setName("finance emp");
        walletPO.setMoney(new BigDecimal("200"));
        walletPO.setFill1("fill1");
        walletPO.setFill2("fill2");
        walletPO.setVersion(1L);
        walletPO.setCreateTime(LocalDateTime.now());
        walletPO.setCreateUser("finance");
        walletPO.setUpdateTime(LocalDateTime.now());
        walletPO.setUpdateUser("finance");
        walletPO.setFlag(StateEnum.NORMAL);
        boolean insert = walletPO.insert();
        log.info("finance 插入:{}",insert);

        log.info("即将调用 insist-service-emp6001 insert服务:{}",insert);
        String insert1 = empWalletService.insert();
        log.info("调用 insist-service-emp6001 插入:{}",insert1);
        return  "finance insertL"+ insert +"\nemp insert:"+insert1;
    }
}
