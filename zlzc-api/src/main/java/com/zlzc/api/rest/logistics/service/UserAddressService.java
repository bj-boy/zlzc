package com.zlzc.api.rest.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.logistics.entity.UserAddressEntity;
import com.zlzc.common.utils.PageUtils;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface UserAddressService extends IService<UserAddressEntity> {

    PageUtils infoByUserId(Map<String, Object> params, String userId);

}
