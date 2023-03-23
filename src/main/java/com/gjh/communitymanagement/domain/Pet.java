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
 * 宠物表
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_pet")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物照片
     */
    private String picture;

    /**
     * 所属成员（业主）名称
     */
    private String ownerName;

    /**
     * 所属成员（业主）ID
     */
    private Integer ownerId;

    /**
     * 宠物名称
     */
    private String name;

    /**
     * 宠物颜色
     */
    private String color;

    /**
     * 备注
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
     * 收养时间
     */
    private LocalDateTime adoptTime;


}
