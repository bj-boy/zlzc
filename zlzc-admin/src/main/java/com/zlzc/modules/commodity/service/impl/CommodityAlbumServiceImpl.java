package com.zlzc.modules.commodity.service.impl;

import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.dao.CommodityAlbumDao;
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.service.CommodityAlbumService;
import com.zlzc.modules.commodity.vo.CommodityAlbumVo;

@Service("commodityAlbumService")
public class CommodityAlbumServiceImpl extends ServiceImpl<CommodityAlbumDao, CommodityAlbumEntity>
		implements CommodityAlbumService {

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean saveBatchSub(Collection<CommodityAlbumVo> entityList, int batchSize) {
		String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
		try (SqlSession batchSqlSession = sqlSessionBatch()) {
			int i = 0;
			for (CommodityAlbumVo commodityAlbumVo : entityList) {
				batchSqlSession.insert(sqlStatement, commodityAlbumVo);
				if (i >= 1 && i % batchSize == 0) {
					batchSqlSession.flushStatements();
				}
				i++;
			}
			batchSqlSession.flushStatements();
		}
		return true;
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityAlbumEntity> page = this.page(new Query<CommodityAlbumEntity>().getPage(params),
				new QueryWrapper<CommodityAlbumEntity>());

		return new PageUtils(page);
	}

}
