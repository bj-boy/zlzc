package com.zlzc.api.rest.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.content.entity.ContentCommentEntity;
import com.zlzc.api.rest.content.entity.ContentLnformationEntity;
import com.zlzc.api.rest.content.vo.ContentLnformationVo;
import com.zlzc.common.utils.PageUtils;

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

}

