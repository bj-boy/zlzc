package com.zlzc.modules.content.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.content.entity.ContentLnformationEntity;
import com.zlzc.modules.content.vo.ContentLnformationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资讯表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface ContentLnformationDao extends BaseMapper<ContentLnformationEntity> {

    public List<ContentLnformationVo> getInformationCommodityById(@Param(Constants.WRAPPER)
                                                                          Wrapper<ContentLnformationVo> queryWrapper);

    public List<ContentLnformationVo> getInformationContentById(@Param(Constants.WRAPPER)
                                                                        Wrapper<ContentLnformationVo> queryWrapper);

    IPage<ContentLnformationEntity> queryPageText(IPage<ContentLnformationEntity> page);
}
