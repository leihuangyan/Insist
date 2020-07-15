package com.lhy.insist.database.master.base;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @name: SuperMapper
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.base.SuperMapper
 * @date: 2019-10-14 19:16
 * @Version: 1.0
 * @description:  mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法

}
