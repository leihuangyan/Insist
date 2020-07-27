package com.lhy.insist.database.master.model.user.service.impl;

import com.lhy.insist.database.master.model.user.entity.UserPO;
import com.lhy.insist.database.master.model.user.dao.IUserDao;
import com.lhy.insist.database.master.model.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user 服务实现类
 * </p>
 *
 * @author lhy
 * @since 2020-07-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserDao, UserPO> implements IUserService {

}
