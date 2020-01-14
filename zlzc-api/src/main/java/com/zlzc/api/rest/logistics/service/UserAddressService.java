package com.zlzc.api.rest.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.logistics.entity.UserAddressEntity;

import java.awt.*;
import java.util.List;

public interface UserAddressService extends IService<UserAddressEntity> {
    //根据用户id查询所以地址
    public List<UserAddressEntity> getListUserByID(String id);

}
