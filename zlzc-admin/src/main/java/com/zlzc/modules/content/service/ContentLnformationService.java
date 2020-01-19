package com.zlzc.modules.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.content.entity.ContentLnformationEntity;
import com.zlzc.modules.content.vo.ContentLnformationVo;
import com.zlzc.modules.content.vo.ContentlnSaveVo;

import java.util.List;
import java.util.Map;

/**
 * 资讯表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface ContentLnformationService extends IService<ContentLnformationEntity> {

    List<ContentLnformationEntity> getInformationService();

    List<ContentLnformationVo> getInformationCommodityByIdService(Long informationId);

    List<ContentLnformationVo> getInformationContentById(Long informationId);

    List<ContentLnformationEntity> getInformationSearchFor(String InformationTitle);

    PageUtils queryPageText(Map<String, Object> params);

    boolean saveText(ContentlnSaveVo contentlnSaveVo);
}

