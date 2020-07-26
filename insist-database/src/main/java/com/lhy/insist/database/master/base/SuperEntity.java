package com.lhy.insist.database.master.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lhy.insist.database.master.enums.StateEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @name: SuperEntity
 * @author: LHY
 * @classPath: com.lhy.insist.database.master.base.SuperEntity
 * @date: 2020/7/13 21:25
 * @Version: 1.0
 * @description: SuperEntity
 */
@Data
public class SuperEntity<T extends Model<T>> extends Model<T> implements Serializable {

    private static final long serialVersionUID = 3795273066087855203L;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField("update_user")
    private String updateUser;

    /**
     * 逻辑状态
     */
    @TableField("logic_state")
    @TableLogic
    private StateEnum logicState;

}
