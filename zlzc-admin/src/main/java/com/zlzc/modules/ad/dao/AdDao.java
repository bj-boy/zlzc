package com.zlzc.modules.ad.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zlzc.modules.ad.entity.AdEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 广告表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface AdDao extends BaseMapper<AdEntity> {

    IPage<AdEntity> queryPageAd(IPage<AdEntity> page);
}
