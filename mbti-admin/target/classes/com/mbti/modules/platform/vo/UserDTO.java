package com.mbti.modules.platform.vo;

import lombok.Data;

/**
 * @author: xiaoqx
 * @date: 2019-09-12 09:33
 * @description: 用户导出
 **/
@Data
public class UserDTO {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 状态
     */
    private String status;
}
