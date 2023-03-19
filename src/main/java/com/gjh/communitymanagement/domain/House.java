package com.gjh.communitymanagement.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 房屋表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_house")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房屋ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属小区名称
     */
    private String communityName;

    /**
     * 所属小区ID
     */
    private Integer communityId;

    /**
     * 所属栋数名称
     */
    private String buildingName;

    /**
     * 所属栋数ID
     */
    private Integer buildingId;

    /**
     * 房产编码
     */
    private String code;

    /**
     * 房产名称
     */
    private String name;

    /**
     * 户主（业主）ID
     */
    private Integer ownerId;

    /**
     * 户主（业主）名称
     */
    private String ownerName;

    /**
     * 联系方式
     */
    private long telephone;

    /**
     * 房间数
     */
    private Integer roomNum;

    /**
     * 单元
     */
    private Integer unit;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 描述
     */
    private String description;

    /**
     * 入住时间
     */
    private Date liveTime;


}
