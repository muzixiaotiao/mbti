package com.mbti.modules.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mbti.common.utils.PageUtils;
import com.mbti.modules.platform.entity.UserEntity;
import com.mbti.modules.platform.vo.ReportDTO;

import java.util.List;
import java.util.Map;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 13:40
 * @description: 测评用户
 **/
public interface UserService extends IService<UserEntity> {

    UserEntity queryByMobile(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    String saveUserReport(UserEntity user, String basePath);

    String getResultCode(List<ReportDTO> reportDTOList, Integer infoId);

    List<UserEntity> queryByInfoId(Integer infoId);

}
