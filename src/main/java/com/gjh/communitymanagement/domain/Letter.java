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
 * 信件表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_letter")
public class Letter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信件ID
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
     * 信件发送者（业主）ID
     */
    private Integer ownerId;

    /**
     * 信件发送者（业主）名称
     */
    private String ownerName;

    /**
     * 信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc
     */
    private String origin;

    /**
     * 信件标题
     */
    private String title;

    /**
     * 信箱内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态:0-未读（默认），1-已读
     */
    private String status;


}
