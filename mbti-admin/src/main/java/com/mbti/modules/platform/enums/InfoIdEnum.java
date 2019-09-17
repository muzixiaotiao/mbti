package com.mbti.modules.platform.enums;

/**
 * @author: xiaoqx
 * @date: 2019-09-09 16:51
 * @description: 测试类型枚举
 **/
public enum InfoIdEnum {
    /**
     * 性格测试
     */
    XING_GE("评测一", 1),
    /**
     * 心理测试
     */
    XIN_LI("评测二", 2),
    ;

    private String info;
    private int code;

    InfoIdEnum(String info, int code) {
        this.info = info;
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
