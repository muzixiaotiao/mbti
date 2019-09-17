package com.mbti.modules.platform.enums;

/**
 * @author: xiaoqx
 * @date: 2019-09-09 16:27
 * @description: 用户测评状态
 **/
public enum StatusEnum {

    NOT_BEGIN("未测评", 0),
    FINISHED("已测评", 1),
    PASS("通过", 2),
    REFUSE("拒绝", 3);
    private String info;
    private int status;
    StatusEnum(String info, int status){
        this.info = info;
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 根据状态码，返回类型的枚举实例。
     *
     * @param status 状态
     */
    public static StatusEnum getByStatus(int status) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getStatus() == status) {
                return statusEnum;
            }
        }
        return null;
    }

}
