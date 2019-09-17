package com.mbti.modules.platform.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 10:20
 * @description: 基类
 **/
@Data
public class BaseEntity {

    /**
     * 主键
     */
    private long id;
    /**
     * 删除状态(Y:删除   N：未删除)
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private String delFlag;
    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;
    /**
     * 修改人
     */
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private String updateUser;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

}
