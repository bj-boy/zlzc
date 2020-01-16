package com.zlzc.api.rest.brand.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.vo.BrandVo;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 品牌管理表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {

    public List<BrandVo> getBrandCategoriesDao(@Param(Constants.WRAPPER)
                                                 Wrapper<BrandVo> queryWrapper);

    public List<BrandVo> getBrandCommodityDao(@Param(Constants.WRAPPER)
                                                      Wrapper<BrandVo> queryWrapper);

    public List<BrandVo> getBrandShopDao(@Param(Constants.WRAPPER)
                                                      Wrapper<BrandVo> queryWrapper);

    public List<BrandVo>getBrandCommentDao(@Param(Constants.WRAPPER)
                                                   Wrapper<BrandVo> queryWrapper);

    public List<BrandVo>getBrandSearchFor(@Param(Constants.WRAPPER)
                                                   Wrapper<BrandVo> queryWrapper);

}
