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
 * 投诉表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_complaint")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投诉ID
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
     * 投诉人员（业主）ID
     */
    private Integer owner_id;

    /**
     * 投诉人员（业主）名称
     */
    private String owner_name;

    /**
     * 投诉具体描述
     */
    private String description;

    /**
     * 投诉事由
     */
    private String reason;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * 状态：0-未受理，1-已受理（默认），2-已处理完毕
     */
    private String status;


}
