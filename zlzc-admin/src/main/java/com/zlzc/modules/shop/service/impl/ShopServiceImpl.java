package com.zlzc.modules.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.shop.dao.ShopDao;
import com.zlzc.modules.shop.entity.ShopEntity;
import com.zlzc.modules.shop.service.ShopService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author LBB
 * @ClassName: ShopServiceImpl
 * @email biaobiao999@163.com
 * @date 2019-12-02 11:35:20
 */
@Service("shopService")
    public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopEntity> implements ShopService {
        @Override
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


}
