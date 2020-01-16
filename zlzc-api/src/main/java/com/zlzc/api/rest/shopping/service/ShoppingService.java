package com.zlzc.api.rest.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.shopping.entity.ShoppingEntity;
import com.zlzc.api.rest.shopping.vo.ShoppingVo;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-15 11:03:02
 */
public interface ShoppingService extends IService<ShoppingEntity> {

    PageUtils queryPage(Map<String, Object> params,ShoppingEntity shoppingEntity);

    List<ShoppingVo> ByPriceShopping(Long commodityId);
}

