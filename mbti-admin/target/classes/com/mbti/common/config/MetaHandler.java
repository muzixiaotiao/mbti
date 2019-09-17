package com.mbti.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mbti.common.utils.DateUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 18:10
 * @description:
 **/
@Component
public class MetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN), metaObject);
        this.setFieldValByName("createUser", "admin", metaObject);
        this.setFieldValByName("updateTime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN), metaObject);
        this.setFieldValByName("updateUser", "admin", metaObject);
        this.setFieldValByName("delFlag", "N", metaObject);
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN), metaObject);
        this.setFieldValByName("updateUser", "admin", metaObject);
    }


}
