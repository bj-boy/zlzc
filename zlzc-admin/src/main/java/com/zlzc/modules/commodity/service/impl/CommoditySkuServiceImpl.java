package com.zlzc.modules.commodity.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommoditySkuDao;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;
import com.zlzc.modules.commodity.service.CommoditySkuService;
import com.zlzc.modules.commodity.vo.CommoditySkuVo;

@Service("commoditySkuService")
public class CommoditySkuServiceImpl extends ServiceImpl<CommoditySkuDao, CommoditySkuEntity>
		implements CommoditySkuService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommoditySkuEntity> page = this.page(new Query<CommoditySkuEntity>().getPage(params),
				new QueryWrapper<CommoditySkuEntity>());

		return new PageUtils(page);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean saveBatchSub(Collection<CommoditySkuVo> entityList, int batchSize) {
		String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
		try (SqlSession batchSqlSession = sqlSessionBatch()) {
			int i = 0;
			for (CommoditySkuVo commoditySkuvo : entityList) {
				batchSqlSession.insert(sqlStatement, commoditySkuvo);
				if (i >= 1 && i % batchSize == 0) {
					batchSqlSession.flushStatements();
				}
				i++;
			}
			batchSqlSession.flushStatements();
		}
		return true;
	}

}
