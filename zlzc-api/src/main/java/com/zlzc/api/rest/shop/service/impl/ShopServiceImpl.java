package com.zlzc.api.rest.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.shop.dao.ShopDao;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shop.service.ShopService;
import com.zlzc.api.rest.shop.vo.ShopVo;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LBB
 * @ClassName: ShopServiceImpl
 * @email biaobiao999@163.com
 * @date 2019-12-02 11:35:20
 */
@Service("shopService")
    public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopEntity> implements ShopService {

       // @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShopEntity> page = this.page(new Query<ShopEntity>().getPage(params), new QueryWrapper<ShopEntity>());
        return new PageUtils(page);
    }

    @Override
    public Map<String, Object> queryShopDetails(Integer shopId) {
        QueryWrapper<ShopEntity> wq = new QueryWrapper<ShopEntity>()
                .eq("sp.shop_id",shopId);

        Map<String, Object> rsMap = baseMapper.queryShopDetails(wq);

        return rsMap;
    }


    @Override
    public PageUtils queryPageWithCnt(Map<String, Object> params, ShopEntity shop) {
        QueryWrapper<ShopEntity> qw = new QueryWrapper<ShopEntity>()
                .eq(StringUtils.isNotBlank(shop.getShopLogoUrl()),"sp.shop_logo_url",shop.getShopLogoUrl())
                .eq(StringUtils.isNotBlank(shop.getMerchantName()),"sp.merchant_name",shop.getMerchantName())
                .eq(StringUtils.isNotBlank(shop.getShopAddr()),"sp.shop_addr",shop.getShopAddr())
                .eq(StringUtils.isNotBlank(shop.getShopLinkman()),"sp.shop_linkman",shop.getShopLinkman())
                .eq(shop.getShopScope()!=null,"sp.shop_scope",shop.getShopScope())
                .eq(shop.getShopStatus()!=null,"sp.shop_status",shop.getShopStatus())
                .groupBy("sp.shop_id");
        IPage<ShopEntity> page = baseMapper.queryPageWithCnt(new Query<ShopEntity>().getPage(params), qw);

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageShop(Map<String, Object> params) {
        IPage<ShopEntity> page = baseMapper.queryPageShop(new Query<ShopEntity>().getPage(params));
        return new PageUtils(page);
    }

    @Override
    public IPage<ShopVo> listShop(Map<String, Object> params, String userName) {

        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>().eq("u.username",userName);

        IPage<ShopVo> shopVoIPage = baseMapper.listShop(new Query<ShopVo>().getPage(params), eq);

        return shopVoIPage;
    }

    @Override
    public List<ShopEntity> ShopByName(String byName) {

        List<ShopEntity> shopNameame = baseMapper.selectList(new QueryWrapper<ShopEntity>()
                .like("shop_name", byName));

        return shopNameame;
    }

    @Override
    public List<ShopVo> shopCommodityByName(String commodityName) {
        List<ShopVo> shopVos = baseMapper.shopCommodityByName(new QueryWrapper<ShopVo>()
                .eq("p.sales_model", 1)
                .like("c.commodity_name", commodityName));

        return shopVos;
    }

    @Override
    public IPage<ShopVo> shopCommodityList(Map<String, Object> params) {

        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>()
                .eq("p.sales_model", 1)
                .orderByDesc("c.create_time");
        IPage<ShopVo> shopVoIPage = baseMapper.shopCommodityList(new Query<ShopVo>().getPage(params), eq);
        return shopVoIPage;
    }

    @Override
    public IPage<ShopVo> shopBrandList(Map<String, Object> params,Long shopId) {
        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>()
                .eq("s.shop_id",shopId);
        IPage<ShopVo> shopVoIPage = baseMapper.shopBrandList(new Query<ShopVo>().getPage(params), eq);
        return shopVoIPage;
    }

    @Override
    public IPage<ShopVo> brandCommodityList(Map<String, Object> params, Long brandId) {
        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>()
                .eq("p.sales_model", 1)
                .eq("b.brand_id",brandId);
        IPage<ShopVo> shopVoIPage = baseMapper.brandCommodityList(new Query<ShopVo>().getPage(params), eq);
        return shopVoIPage;
    }

    @Override
    public List<ShopVo> shopCommodityFL(Long shopId) {
        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>()
                .groupBy("ca.category_name")
                .isNotNull("ca.category_name");
        List<ShopVo> shopVos = baseMapper.shopCommodityFL(eq);
        return shopVos;
    }

    @Override
    public ShopVo shopMerchantIntroduction(Long shopId) {
        QueryWrapper<ShopVo> eq = new QueryWrapper<ShopVo>()
                .eq("s.shop_id",shopId);
        ShopVo hopMerchantVo = baseMapper.shopMerchantIntroduction(eq);
        return hopMerchantVo;
    }


}
