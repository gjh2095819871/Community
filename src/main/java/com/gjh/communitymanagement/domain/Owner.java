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
 * 业主表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_owner")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业主ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属小区
     */
    private Integer communityId;

    /**
     * 所属房产
     */
    private Integer houseId;

    /**
     * 成员名称
     */
    private String name;

    /**
     * 成员照片
     */
    private String picture;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 联系方式
     */
    private Long telephone;

    /**
     * 职业
     */
    private String profession;

    /**
     * 性别:0-男（默认），1-女
     */
    private String sex;

    /**
     * 类型:0-房主（默认），1-租客
     */
    private String type;

    /**
     * 备注（默认无）
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;


}
