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
 * 物业管理人员表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_estate_manager")
public class EstateManager implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物业管理人员ID
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
     * 登录名:登录时使用的名称
     */
    private String login_name;

    /**
     * 真实名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private Integer telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色ID：0-普通用户（默认0），1-管理员用户
     */
    private Integer role_id;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;


}
