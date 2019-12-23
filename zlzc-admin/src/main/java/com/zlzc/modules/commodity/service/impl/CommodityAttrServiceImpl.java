package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityAttrDao;
import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.service.CommodityAttrService;
import com.zlzc.modules.commodity.vo.CommodityAttrVo;


@Service("commodityAttrService")
public class CommodityAttrServiceImpl extends ServiceImpl<CommodityAttrDao, CommodityAttrEntity> implements CommodityAttrService {

	/* ##################### 商品属性 ##################### */

	/**
	 * 商品属性列表(支持分页及条件)
	 */
	public void commodityAttrList() {
		
	}

	/**
	 * 保存商品属性
	 */
	public void saveCommodityAttr(CommodityAttrVo commodityAttr) {

	}

	/**
	 * 修改商品属性
	 */
	public void updCommodityAttr(CommodityAttrVo commodityAttr) {

	}

	/**
	 * 删除商品属性
	 */
	public void delCommodityAttr(Long[] commodityAttrIds) {

	}

	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityAttrEntity> page = this.page(
                new Query<CommodityAttrEntity>().getPage(params),
                new QueryWrapper<CommodityAttrEntity>()
        );

        return new PageUtils(page);
    }

}
