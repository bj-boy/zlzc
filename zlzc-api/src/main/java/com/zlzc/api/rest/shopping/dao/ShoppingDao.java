package com.zlzc.api.rest.shopping.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.api.rest.shopping.entity.ShoppingEntity;
import com.zlzc.api.rest.shopping.vo.ShoppingVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-15 11:03:02
 */
@Mapper
public interface ShoppingDao extends BaseMapper<ShoppingEntity> {

    IPage<ShoppingVo> queryShoppingPage(IPage<ShoppingVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    List<ShoppingVo> ByPriceShopping(@Param(Constants.WRAPPER) Wrapper<ShoppingVo> queryWrapper);
}
