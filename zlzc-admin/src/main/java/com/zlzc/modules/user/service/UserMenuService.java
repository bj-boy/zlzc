package com.zlzc.modules.user.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.user.entity.UserMenuEntity;

/**
 * 用户与菜单对应关系
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-15 16:54:58
 */
public interface UserMenuService extends IService<UserMenuEntity> {

	int deleteBatch(Long[] userIds);

	List<Long> queryMenuIdList(Long userId);

	void saveOrUpdate(Long userId, List<Long> menuIdList);

	
	
}

