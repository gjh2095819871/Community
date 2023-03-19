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
    private String community_name;

    /**
     * 所属小区ID
     */
    private Integer community_id;

    /**
     * 车位编号
     */
    private String code;

    /**
     * 车牌号码
     */
    private String car_number;

    /**
     * 车辆牌照（照片）
     */
    private String picture;

    /**
     * 车辆所有人（业主）名称
     */
    private String owner_name;

    /**
     * 车辆所有人（业主）ID
     */
    private Integer owner_id;

    /**
     * 联系方式
     */
    private Integer telephone;

    /**
     * 使用性质：0-购买(默认)，1-月租，2-年租
     */
    private String use_type;

    /**
     * 总费用(￥)，以分为单位
     */
    private Integer total_fee;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * （使用）开始时间
     */
    private LocalDateTime start_time;

    /**
     * （使用）结束时间
     */
    private LocalDateTime end_time;


}
