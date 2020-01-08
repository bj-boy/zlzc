package com.zlzc.api.rest.shop.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.commodity.vo.CommodityAttrPageVo;
import com.zlzc.modules.shop.entity.ShopEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
