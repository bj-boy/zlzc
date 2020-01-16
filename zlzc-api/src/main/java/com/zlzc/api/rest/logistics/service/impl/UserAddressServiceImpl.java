package com.zlzc.api.rest.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.logistics.dao.LogisticsDao;
import com.zlzc.api.rest.logistics.dao.UserAddressDao;
import com.zlzc.api.rest.logistics.entity.LogisticsEntity;
import com.zlzc.api.rest.logistics.entity.UserAddressEntity;
import com.zlzc.api.rest.logistics.service.LogisticsService;
import com.zlzc.api.rest.logistics.service.UserAddressService;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shopping.vo.ShoppingVo;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("UserAddressService")
@Slf4j
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao,UserAddressEntity> implements UserAddressService {


    @Override
    public PageUtils infoByUserId(Map<String, Object> params,String userId) {

        QueryWrapper<UserAddressEntity> user = new QueryWrapper<UserAddressEntity>()
                    .eq("user_id", userId);
        IPage<UserAddressEntity> page = this.page(new Query<UserAddressEntity>().getPage(params),
                user);
        return new PageUtils(page);
    }


}
