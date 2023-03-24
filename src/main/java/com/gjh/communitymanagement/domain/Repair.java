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
    private String communityName;

    /**
     * 所属小区ID
     */
    private Integer communityId;

    /**
     * 所属楼栋名称
     */
    private String buildingName;

    /**
     * 所属楼栋ID
     */
    private Integer buildingId;

    /**
     * 报修人员（业主）名称
     */
    private String ownerName;

    /**
     * 报修人员（业主）ID
     */
    private Integer ownerId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备编号ID
     */
    private Integer deviceId;

    /**
     * 报修描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态：0-待受理，1-已受理，2-修理完毕
     */
    private String status;


}
