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

    @TableField("createDate")
    private LocalDateTime createDate;

    @TableField("createCode")
    private String createCode;

    @TableField("updateDate")
    private LocalDateTime updateDate;

    @TableField("updateCode")
    private String updateCode;

    @TableField("state")
    @TableLogic
    private StateEnum state;

}
