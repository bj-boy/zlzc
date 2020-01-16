package com.zlzc.modules.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.user.dao.UserMenuDao;
import com.zlzc.modules.user.entity.UserMenuEntity;
import com.zlzc.modules.user.service.UserMenuService;

@Service("userMenuService")
public class UserMenuServiceImpl extends ServiceImpl<UserMenuDao, UserMenuEntity> implements UserMenuService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long userId, List<Long> menuIdList) {
		// 先删除角色与菜单关系
		deleteBatch(new Long[] { userId });

		if (menuIdList.size() == 0) {
			return;
		}

		// 保存角色与菜单关系
		for (Long menuId : menuIdList) {
			UserMenuEntity userMenuEntity = new UserMenuEntity();
			userMenuEntity.setMenuId(menuId);
			userMenuEntity.setUserId(userId);

			this.save(userMenuEntity);
		}
	}

	@Override
	public List<Long> queryMenuIdList(Long userId) {
		return baseMapper.queryMenuIdList(userId);
	}

	@Override
	public int deleteBatch(Long[] userIds) {
		return baseMapper.deleteBatch(userIds);
	}

}
