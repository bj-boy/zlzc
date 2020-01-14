package com.zlzc.api.rest.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.logistics.dao.LogisticsDao;
import com.zlzc.api.rest.logistics.dao.UserAddressDao;
import com.zlzc.api.rest.logistics.entity.LogisticsEntity;
import com.zlzc.api.rest.logistics.entity.UserAddressEntity;
import com.zlzc.api.rest.logistics.service.LogisticsService;
import com.zlzc.api.rest.logistics.service.UserAddressService;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UserAddressService")
@Slf4j
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao,UserAddressEntity> implements UserAddressService {

    @Override
    public List<UserAddressEntity> getListUserByID(String userID) {

        QueryWrapper<UserAddressEntity> wq = new QueryWrapper<UserAddressEntity>()
                .eq("user_id",userID);

        List<UserAddressEntity> list = this.list(wq);
        return list;
    }
}
