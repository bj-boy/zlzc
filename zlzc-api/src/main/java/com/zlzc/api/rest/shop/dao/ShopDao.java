package com.zlzc.api.rest.shop.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.zlzc.api.rest.commodity.vo.CommodityAttrPageVo;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shop.vo.ShopVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ShopDao
 * @author LBB
 * @email biaobiao999@163.com
 * @date 2019-12-02 11:06:01 
 *
 */
@Mapper
public interface ShopDao extends BaseMapper<ShopEntity> {

    IPage<ShopEntity> queryPageWithCnt(IPage<ShopEntity> page, @Param(Constants.WRAPPER) Wrapper wrapper);

   // IPage<ShopEntity> queryShop(IPage<ShopEntity> page);

    public Map<String, Object> queryShopDetails(
            @Param(Constants.WRAPPER) QueryWrapper<ShopEntity> queryWrapper);

    IPage<CommodityAttrPageVo> queryPage(IPage<CommodityAttrPageVo> page);

    IPage<ShopEntity> queryPageShop(IPage<ShopEntity> page);

    IPage<ShopVo> listShop(IPage<ShopVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    List<ShopVo> shopCommodityByName( @Param(Constants.WRAPPER) Wrapper wrapper);

    IPage<ShopVo> shopCommodityList(IPage<ShopVo> page,@Param(Constants.WRAPPER) Wrapper wrapper);

    IPage<ShopVo> shopBrandList(IPage<ShopVo> page,@Param(Constants.WRAPPER) Wrapper wrapper);

    IPage<ShopVo> brandCommodityList(IPage<ShopVo> page,@Param(Constants.WRAPPER) Wrapper wrapper);

    List<ShopVo> shopCommodityFL(@Param(Constants.WRAPPER) Wrapper wrapper);

    ShopVo shopMerchantIntroduction(@Param(Constants.WRAPPER) Wrapper wrapper);

}
