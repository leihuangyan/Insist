package com.lhy.insist.database.master.model.wallet.service.impl;

import com.lhy.insist.database.master.model.wallet.entity.WalletPO;
import com.lhy.insist.database.master.model.wallet.dao.IWalletDao;
import com.lhy.insist.database.master.model.wallet.service.IWalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 钱包 服务实现类
 * </p>
 *
 * @author lhy
 * @since 2020-07-28
 */
@Service
public class WalletServiceImpl extends ServiceImpl<IWalletDao, WalletPO> implements IWalletService {

}
