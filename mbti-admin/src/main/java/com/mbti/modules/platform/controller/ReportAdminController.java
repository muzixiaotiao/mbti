package com.mbti.modules.platform.controller;

import com.mbti.common.utils.*;
import com.mbti.modules.platform.entity.AnalysisEntity;
import com.mbti.modules.platform.entity.UserEntity;
import com.mbti.modules.platform.enums.InfoIdEnum;
import com.mbti.modules.platform.enums.StatusEnum;
import com.mbti.modules.platform.service.AnalysisService;
import com.mbti.modules.platform.service.UserService;
import com.mbti.modules.platform.vo.ReportVO;
import com.mbti.modules.platform.vo.UserDTO;
import com.mbti.modules.sys.entity.SysUserEntity;
import com.mbti.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: xiaoqx
 * @date: 2019-09-05 15:26
 * @description: 测评用户管理
 **/

@Controller
@RequestMapping("/api/report")
public class ReportAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private SysUserService sysUserService;

    @Value("${doc.file.path}")
    private String basePath;

    /**
     * 用户报告列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public RespResult queryUserReport(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        RespResult result = new RespResult(RespResult.SUCCESS, page);
        return result;
    }

    /**
     * 单个用户报告下载
     * @param request
     * @param response
     * @param userId
     */
    @RequestMapping("/single_download/{userId}")
    public void downLoadUserReport(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") Integer userId){
        UserEntity user = userService.getById(userId);
        String filePath = basePath + user.getFilePath();
        File userFile = new File(filePath);
        if(!userFile.exists()){
            userService.saveUserReport(user, basePath);
        }
        PoiUtils.downloadFile(filePath, request, response);
    }

    /**
     * 批量用户报告下载
     * @param response
     * @param userIds
     */
    @RequestMapping("/many_download")
    public void downLoadUserReportMany(HttpServletResponse response, @RequestBody List<Long> userIds){
        String zipName = DateUtils.format(new Date(), "yyyyMMddHHmmss");
        List<UserEntity> userList = (List<UserEntity>) userService.listByIds(userIds);
        for(UserEntity user : userList){
            String filePath = user.getFilePath();
            File file = new File(filePath);
            //如果文件不存在先生成文件再下载
            if(!file.exists()){
               userService.saveUserReport(user, basePath);
            }
        }
        PoiUtils.downloadWordFileMany(response, zipName, userList, basePath);
    }



    /**
     * 更新用户状态 status
     * @param id 用户ID
     * @param status 用户状态
     * @return
     */
    @RequestMapping("/status")
    @ResponseBody
    public RespResult queryUserReport(@RequestParam("id") Long id, @RequestParam("status") Integer status){
        UserEntity user = userService.getById(id);
        user.setStatus(status);
        userService.updateById(user);
        RespResult result = new RespResult(RespResult.SUCCESS, "修改成功");
        return result;
    }

    /**
     * 查看用户报告
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/view/{id}")
    @ResponseBody
    public RespResult queryUserReport(@PathVariable("id") Long id){
        UserEntity user = userService.getById(id);
        String code = user.getAnalysisCode();
        AnalysisEntity analysis = analysisService.queryByCode(code);
        ReportVO reportVO = new ReportVO();
        reportVO.setMobile(user.getMobile());
        reportVO.setContent(analysis.getContent());
        reportVO.setCreateTime(user.getCreateTime());
        reportVO.setStatus(user.getStatus());
        RespResult result = new RespResult(RespResult.SUCCESS, reportVO);
        return result;
    }

    @RequestMapping("/admin")
    @ResponseBody
    public RespResult adminLogin(@RequestParam("mobile") String mobile){
        SysUserEntity user = sysUserService.getByMobile(mobile);
        if(null == user){
            return new RespResult(RespResult.FAIL, "账号不存在");
        }
        RespResult result = new RespResult(RespResult.SUCCESS, "登录成功", user);
        return result;
    }

    @RequestMapping("/login/{mobile}")
    @ResponseBody
    public RespResult reportLogin(@PathVariable("mobile") String mobile){
        SysUserEntity user = sysUserService.getByMobile(mobile);
        if(null == user){
            return new RespResult(RespResult.FAIL, "账号不存在");
        }
        RespResult result = new RespResult(RespResult.SUCCESS, "登录成功", user);
        return result;
    }

    /**
     * 列表导出功能
     * @param response
     */
    @RequestMapping("/export/{infoId}")
    public void exportUsers(HttpServletResponse response, @PathVariable("infoId") Integer infoId) throws IOException {
        List<UserEntity> userList = userService.queryByInfoId(infoId);
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity user : userList){
            UserDTO userDTO = new UserDTO();
            userDTO.setMobile(user.getMobile());
            userDTO.setCreateTime(user.getCreateTime());
            userDTO.setStatus(StatusEnum.getByStatus(user.getStatus()).getInfo());
            userDTOList.add(userDTO);
        }
        String[] headers = {"手机号", "测评时间", "测评结果"};
        String now = DateUtils.format(new Date(), "yyyyMMddHHmmss");
        String title = "";
        String fileName = "";
        if(infoId == InfoIdEnum.XING_GE.getCode()){
            title = "评测一";
            fileName = "评测一用户列表_" + now;
        }else if(infoId == InfoIdEnum.XIN_LI.getCode()){
            title = "评测二";
            fileName = "评测二用户列表_" + now;
        }
        ExportExcelWrapper<UserDTO> exportExcelWrapper = new ExportExcelWrapper<>();
        exportExcelWrapper.exportExcel(fileName, title, headers, userDTOList, response, ExportExcelUtil.EXCEL_FILE_2003);
    }

}
