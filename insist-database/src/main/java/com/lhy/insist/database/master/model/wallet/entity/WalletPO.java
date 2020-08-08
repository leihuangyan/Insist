package com.lhy.insist.database.master.model.wallet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.lhy.insist.database.master.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 钱包
 * </p>
 *
 * @author lhy
 * @since 2020-07-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_wallet")
public class WalletPO extends SuperEntity<WalletPO> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId("id")
    private String id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 钱
     */
    @TableField("money")
    private BigDecimal money;

    /**
     * 填充1
     */
    @TableField("fill1")
    private String fill1;

    /**
     * 填充2
     */
    @TableField("fill2")
    private String fill2;

    /**
     * 乐观锁
     */
    @TableField("version")
    @Version
    private Long version;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
