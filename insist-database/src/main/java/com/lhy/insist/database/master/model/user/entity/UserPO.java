package com.lhy.insist.database.master.model.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lhy.insist.database.master.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * user
 * </p>
 *
 * @author lhy
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class UserPO extends SuperEntity<UserPO> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名字
     */
    @TableField("user_name")
    private String userName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("addr")
    private String addr;

    /**
     * 签名
     */
    @TableField("sign")
    private String sign;

    /**
     * 爱好
     */
    @TableField("love")
    private String love;

    /**
     * 擅长
     */
    @TableField("good_at")
    private String goodAt;

    /**
     * 标签
     */
    @TableField("tag")
    private String tag;

    /**
     * 其他
     */
    @TableField("other")
    private String other;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
