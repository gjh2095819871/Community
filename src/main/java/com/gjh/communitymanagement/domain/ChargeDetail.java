package com.gjh.communitymanagement.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收费名细表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_charge_detail")
public class ChargeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收费明细ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属小区ID
     */
    private Integer communityId;

    /**
     * 所属小区名称
     */
    private String communityName;

    /**
     * 收费项目ID
     */
    private Integer chargeItemId;

    /**
     * 收费项目名称
     */
    private String chargeItemName;

    /**
     * 承办人名称
     */
    private String contractor;

    /**
     * 承办人联系电话
     */
    private Long telephone;

    /**
     * 应收金额(￥)，单位分
     */
    private Integer payMoney;

    /**
     * 实收金额(￥)，单位分
     */
    private Integer actualMoney;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 缴费时间
     */
    private LocalDateTime payTime;

    /**
     * 状态：0-生效中（默认），1-已过期
     */
    private String status;


}
