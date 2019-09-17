package com.mbti.modules.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbti.common.utils.Constant;
import com.mbti.common.utils.PageUtils;
import com.mbti.common.utils.PoiUtils;
import com.mbti.common.utils.Query;
import com.mbti.modules.platform.dao.UserDao;
import com.mbti.modules.platform.entity.AnalysisEntity;
import com.mbti.modules.platform.entity.UserEntity;
import com.mbti.modules.platform.enums.AnwserTypeEnum;
import com.mbti.modules.platform.enums.InfoIdEnum;
import com.mbti.modules.platform.enums.StatusEnum;
import com.mbti.modules.platform.service.AnalysisService;
import com.mbti.modules.platform.service.UserService;
import com.mbti.modules.platform.vo.ReportDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xiaoqx
 * @date: 2019-09-04 13:47
 * @description: 测评用户
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private AnalysisService analysisService;

    @Override
    public UserEntity queryByMobile(Map<String, Object> params){
        return baseMapper.queryByMobile(params);
    }

    private static final int ANWSER_SCORE = 6;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String mobile = (String)params.get("mobile");
        Integer infoId = Integer.parseInt(params.get("infoId").toString());
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
                        .ne("status", 0)
                        .eq("info_id", infoId)
                        .like(StringUtils.isNotBlank(mobile),"mobile", mobile)
                        .orderByDesc("create_time")
                        .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );
        return new PageUtils(page);
    }

    @Override
    public String saveUserReport(UserEntity user, String basePath){
        String mobile = user.getMobile();
        String code = user.getAnalysisCode();
        Integer infoId = user.getInfoId();
        AnalysisEntity analysis = analysisService.queryByCode(code);
        String content = analysis.getContent();
        String filePath = mobile;
        if(infoId == InfoIdEnum.XING_GE.getCode()){
            filePath = filePath + "_test1.doc";
        }else if(infoId == InfoIdEnum.XIN_LI.getCode()) {
            filePath = filePath + "_test2.doc";
        }
        PoiUtils.saveWordFile(content, filePath, basePath);
        return filePath;
    }

    @Override
    public String getResultCode(List<ReportDTO> reportDTOList, Integer infoId){
        String code = "";
        if(infoId == InfoIdEnum.XING_GE.getCode()){
            //性格测试
            //四个维度取较高的组合性格类型结果 EI SN TF JP
            code = this.getCharacterCode(reportDTOList);
        }else if(infoId == InfoIdEnum.XIN_LI.getCode()) {
            //心理测试
            code = this.getMentalityCode(reportDTOList);
        }
        return code;
    }

    /**
     * 根据统计结果 组合性格类型编码 ISFJ
     * @param reportDTOList
     * @return
     */
    private String getCharacterCode(List<ReportDTO> reportDTOList){
        Map<String, Integer> reportMap = new HashMap<>();
        for(ReportDTO reportDTO : reportDTOList){
            reportMap.put(reportDTO.getCode(), reportDTO.getScore());
        }
        //四个维度取较高的组合性格类型结果 EI SN TF JP
        Integer scoreE = reportMap.get(AnwserTypeEnum.E.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.E.toString());
        Integer scoreI = reportMap.get(AnwserTypeEnum.I.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.I.toString());
        Integer scoreS = reportMap.get(AnwserTypeEnum.S.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.S.toString());
        Integer scoreN = reportMap.get(AnwserTypeEnum.N.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.N.toString());
        Integer scoreT = reportMap.get(AnwserTypeEnum.T.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.T.toString());
        Integer scoreF = reportMap.get(AnwserTypeEnum.F.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.F.toString());
        Integer scoreJ = reportMap.get(AnwserTypeEnum.J.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.J.toString());
        Integer scoreP = reportMap.get(AnwserTypeEnum.P.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.P.toString());
        String code = "";
        if(scoreE > scoreI){
            code = code + AnwserTypeEnum.E;
        }else{
            code = code + AnwserTypeEnum.I;
        }
        if(scoreS > scoreN){
            code = code + AnwserTypeEnum.S;
        }else{
            code = code + AnwserTypeEnum.N;
        }
        if(scoreT > scoreF){
            code = code + AnwserTypeEnum.T;
        }else{
            code = code + AnwserTypeEnum.F;
        }
        if(scoreJ > scoreP){
            code = code + AnwserTypeEnum.J;
        }else{
            code = code + AnwserTypeEnum.P;
        }
        return code;
    }

    /**
     * 心理测试结果 取得分最高的
     * @param reportDTOList
     * @return
     */
    private String getMentalityCode(List<ReportDTO> reportDTOList){
        Map<String, Integer> reportMap = new HashMap<>();
        for(ReportDTO reportDTO : reportDTOList){
            reportMap.put(reportDTO.getCode(), reportDTO.getScore());
        }
        String code = "";
        Integer scoreA = reportMap.get(AnwserTypeEnum.A.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.A.toString());
        Integer scoreB = reportMap.get(AnwserTypeEnum.B.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.B.toString());
        Integer scoreC = reportMap.get(AnwserTypeEnum.C.toString()) == null ? 0 : reportMap.get(AnwserTypeEnum.C.toString());
        if(scoreA >= ANWSER_SCORE){
            code = AnwserTypeEnum.A.toString();
        }else if(scoreB >= ANWSER_SCORE){
            code = AnwserTypeEnum.B.toString();
        }else if(scoreC >= ANWSER_SCORE){
            code = AnwserTypeEnum.C.toString();
        }else{
            code = AnwserTypeEnum.D.toString();
        }
        return code;
    }

    @Override
    public List<UserEntity> queryByInfoId(Integer infoId){
        List<UserEntity> list = this.baseMapper.selectList(
                new QueryWrapper<UserEntity>()
                .eq("info_id", infoId)
                .ne("status", StatusEnum.NOT_BEGIN.getStatus()));
        return list;
    }
}
