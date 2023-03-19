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
 * 维修表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_repair")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 维修ID
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
     * 所属楼栋名称
     */
    private String building_name;

    /**
     * 所属楼栋ID
     */
    private Integer building_id;

    /**
     * 报修人员（业主）名称
     */
    private String owner_name;

    /**
     * 报修人员（业主）ID
     */
    private Integer owner_id;

    /**
     * 设备名称
     */
    private String device_name;

    /**
     * 设备编号ID
     */
    private Integer device_id;

    /**
     * 报修描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * 状态：0-待受理，1-已受理，2-修理完毕
     */
    private String status;


}
