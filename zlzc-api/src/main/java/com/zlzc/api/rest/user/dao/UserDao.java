package com.zlzc.api.rest.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-14 15:50:18
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
