package com.zlzc.modules.dictArea.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.dictArea.dao.DictAreaDao;
import com.zlzc.modules.dictArea.entity.DictAreaEntity;
import com.zlzc.modules.dictArea.service.DictAreaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictAreaService")
public class DictAreaServiceImpl extends ServiceImpl<DictAreaDao, DictAreaEntity> implements DictAreaService {




    @Override
    public List<DictAreaEntity> dictAreaByParentId(Long parentId) {
        QueryWrapper<DictAreaEntity> wq = new QueryWrapper<DictAreaEntity>()
                .eq("da.parent_id",parentId)
                .groupBy("order_by");
        List<DictAreaEntity> dictAreaEntities = baseMapper.dictAreaByParentId(wq);
        return dictAreaEntities;
    }

    @Override
    public List<DictAreaEntity> dictAreaList(Long parentId) {
        QueryWrapper<DictAreaEntity> wq = new QueryWrapper<DictAreaEntity>();
        List<DictAreaEntity> dictAreaEntities = baseMapper.dictAreaList(wq);
        return dictAreaEntities;
    }
}



