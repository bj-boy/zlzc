package com.zlzc.modules.shop.respType;

import com.zlzc.modules.shop.entity.ShopEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.shop.respType
 * @ClassName: queryPageShopRT
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/9 19:28
 * @Version: 1.0
 */
public class queryPageShopRT extends ShopEntity {
    @ApiModelProperty(name = "commodityCnt", value = "店铺上架商品数量")
    private Integer commodityCnt;
}
