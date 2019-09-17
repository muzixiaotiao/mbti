package com.mbti.modules.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbti.modules.platform.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 11:33
 * @description: 测评用户
 **/
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    UserEntity queryByMobile(Map<String, Object> params);
}
