package com.mbti.modules.platform.controller;

import com.alibaba.fastjson.JSON;
import com.mbti.common.utils.RespResult;
import com.mbti.modules.platform.entity.UserEntity;
import com.mbti.modules.platform.enums.StatusEnum;
import com.mbti.modules.platform.service.AnwserService;
import com.mbti.modules.platform.service.UserService;
import com.mbti.modules.platform.vo.ReportDTO;
import com.mbti.modules.platform.vo.ReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 13:54
 * @description: 测评用户
 **/
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnwserService anwserService;

    @Value("${doc.file.path}")
    private String basePath;

    /**
     * 用户注册
     * @param mobile
     * @return
     */
    @RequestMapping("/login/{mobile}/{infoId}")
    @ResponseBody
    public RespResult queryUserByMobile(@PathVariable("mobile") String mobile, @PathVariable("infoId") Integer infoId){
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("infoId", infoId);
        UserEntity user = userService.queryByMobile(params);
        if(user == null){
            user = new UserEntity();
            user.setMobile(mobile);
            user.setStatus(StatusEnum.NOT_BEGIN.getStatus());
            user.setInfoId(infoId);
            userService.save(user);
        }
        RespResult result = new RespResult(RespResult.SUCCESS, user);
        return result;
    }

    /**
     * 测评结果保存并生成评测报告
     * @param reportRequest
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public RespResult reportUserCharacter(@RequestBody ReportRequest reportRequest){
        String mobile = reportRequest.getMobile();
        Integer infoId = reportRequest.getInfoId();
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("infoId", infoId);
        UserEntity user = userService.queryByMobile(params);
        //验证未测试状态
        if(user.getStatus() != StatusEnum.NOT_BEGIN.getStatus()){
            RespResult result = new RespResult(RespResult.FAIL, "已经测评过");
            return result;
        }
        //根据答案ID列表统计各性格类型得分
        List<Long> anwserList = reportRequest.getAnwserList();
        List<ReportDTO> reportDTOList = anwserService.countCharacterScore(anwserList);
        //根据试题类型 组合不同的测试结果编码
        String code = userService.getResultCode(reportDTOList, infoId);
        user.setStatus(1);
        user.setAnalysisCode(code);
        user.setDetail(JSON.toJSONString(reportDTOList));
        //查询结果生成word报告 返回相对路径
        String filePath = userService.saveUserReport(user, basePath);
        //保存至用户表，更新已测评状态
        user.setFilePath(filePath);
        userService.updateById(user);
        RespResult result = new RespResult(RespResult.SUCCESS, "提交成功");
        return result;
    }

}
