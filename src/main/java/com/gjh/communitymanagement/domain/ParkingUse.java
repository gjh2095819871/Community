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
 * 车位使用表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_parking_use")
public class ParkingUse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车位使用ID
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
     * 车位编号
     */
    private String code;

    /**
     * 车牌号码
     */
    private String carNumber;

    /**
     * 车辆牌照（照片）
     */
    private String picture;

    /**
     * 车辆所有人（业主）名称
     */
    private String ownerName;

    /**
     * 车辆所有人（业主）ID
     */
    private Integer ownerId;

    /**
     * 联系方式
     */
    private Long telephone;

    /**
     * 使用性质：0-购买(默认)，1-月租，2-年租
     */
    private String useType;

    /**
     * 总费用(￥)，以分为单位
     */
    private Integer totalFee;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * （使用）开始时间
     */
    private LocalDateTime startTime;

    /**
     * （使用）结束时间
     */
    private LocalDateTime endTime;


}
