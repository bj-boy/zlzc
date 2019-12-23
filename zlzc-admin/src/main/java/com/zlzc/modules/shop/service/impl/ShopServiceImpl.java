package com.zlzc.modules.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
    public PageUtils queryPageByCondition(Map<String, Object> params, ShopEntity shop) {
        //@formatter:off
        LambdaQueryWrapper<ShopEntity> qw = Wrappers.<ShopEntity>lambdaQuery()
                .eq(StringUtils.isNotBlank(shop.getShopLogoUrl()),ShopEntity::getShopLogoUrl,shop.getShopLogoUrl())
                .eq(StringUtils.isNotBlank(shop.getMerchantName()),ShopEntity::getMerchantName,shop.getMerchantName())
                .eq(StringUtils.isNotBlank(shop.getShopAddr()),ShopEntity::getShopAddr,shop.getShopAddr())
                .eq(StringUtils.isNotBlank(shop.getShopLinkman()),ShopEntity::getShopLinkman,shop.getShopLinkman())
                .eq(shop.getShopScope()!=null,ShopEntity::getShopScope,shop.getShopScope())
                .eq(shop.getShopStatus()!=null,ShopEntity::getShopStatus,shop.getShopStatus());
        IPage<ShopEntity> page = this.page(new Query<ShopEntity>().getPage(params), qw);

        return new PageUtils(page);

    }


}
