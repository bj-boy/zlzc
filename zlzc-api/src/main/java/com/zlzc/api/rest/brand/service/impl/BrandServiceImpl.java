package com.zlzc.api.rest.brand.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.brand.dao.BrandDao;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.service.BrandService;
import com.zlzc.api.rest.brand.vo.BrandVo;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
   private  BrandDao brandDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<BrandEntity> getreCommendList(int commend) {
        QueryWrapper<BrandEntity> wq = new QueryWrapper<BrandEntity>()
                .eq("brand_recommend",commend);
        List<BrandEntity> brandEntities = baseMapper.selectList(wq);
        return brandEntities;
    }

    @Override
    public List<BrandVo> getBrandCategoriesService(String  categoriesName) {
        QueryWrapper<BrandVo> wq = new QueryWrapper<BrandVo>()
                .eq("brand_category_name",categoriesName);
        List<BrandVo> brandCategoriesDao = brandDao.getBrandCategoriesDao(wq);

        return brandCategoriesDao;
    }

    @Override
    public List<BrandVo> getBrandCommodityService(Long brandId) {
        QueryWrapper<BrandVo> wq = new QueryWrapper<BrandVo>()
                .eq("b.brand_id",brandId);
        List<BrandVo> BrandCommodityDao =brandDao.getBrandCommodityDao(wq);
        return BrandCommodityDao;
    }

    @Override
    public List<BrandVo> getBrandShopService(Long brandId) {
        QueryWrapper<BrandVo> wq = new QueryWrapper<BrandVo>()
                .eq("b.brand_id",brandId);
        List<BrandVo>  brandShop=brandDao.getBrandShopDao(wq);
        return brandShop;
    }

    @Override
    public List<BrandVo> getBrandCommentService(Long brandId) {
        QueryWrapper<BrandVo> wq = new QueryWrapper<BrandVo>()
                .eq("b.brand_id",brandId);

        return null;
    }

    @Override
    public  List<BrandVo> getBrandSearchFor(String brandName) {
        QueryWrapper<BrandVo> wq = new QueryWrapper<BrandVo>()
                .like("brand_name",brandName);
        List<BrandVo> brandSearchFor = brandDao.getBrandSearchFor(wq);
        return brandSearchFor;
    }


}
