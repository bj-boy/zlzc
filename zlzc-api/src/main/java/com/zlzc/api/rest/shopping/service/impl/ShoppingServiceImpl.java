package com.zlzc.api.rest.shopping.service.impl;

import com.zlzc.api.rest.shopping.dao.ShoppingDao;
import com.zlzc.api.rest.shopping.entity.ShoppingEntity;
import com.zlzc.api.rest.shopping.service.ShoppingService;
import com.zlzc.api.rest.shopping.vo.ShoppingVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("shoppingService")
public class ShoppingServiceImpl extends ServiceImpl<ShoppingDao, ShoppingEntity> implements ShoppingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,ShoppingEntity shoppingEntity) {

        QueryWrapper<ShoppingVo> userId= new QueryWrapper<ShoppingVo>();
        if(Objects.nonNull(shoppingEntity.getUserId())){
            userId = new QueryWrapper<ShoppingVo>()
                    .eq("user_id", shoppingEntity.getUserId())
                    .eq("p.sales_model",1);
        }
         IPage<ShoppingVo> page = baseMapper.queryShoppingPage(new Query<ShoppingVo>().getPage(params),
                userId);

        return new PageUtils(page);
    }

    @Override
    public List<ShoppingVo> ByPriceShopping(Long commodityId) {
        QueryWrapper<ShoppingVo> qw = new QueryWrapper<ShoppingVo>()
                .eq("c.commodity_id",commodityId);
        List<ShoppingVo> shoppingVo = baseMapper.ByPriceShopping(qw);
        return shoppingVo;
    }

}
