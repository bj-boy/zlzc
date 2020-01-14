package com.zlzc.modules.dict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.dict.dao.DictDao;
import com.zlzc.modules.dict.entity.DictEntity;
import com.zlzc.modules.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictDao, DictEntity> implements DictService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<DictEntity> getDict(String dictLabel) {
       List<Object> cacheDictEntityList = redisTemplate.opsForList().range(dictLabel, 0, -1);

       if (cacheDictEntityList.size() < 1) {
            // 条件构造器 where ....
            QueryWrapper<DictEntity> wq = new QueryWrapper<DictEntity>().eq("dict_label",dictLabel);
            List<DictEntity> dictEntityList = this.list(wq);
            Long rows = redisTemplate.opsForList().leftPushAll(dictLabel, dictEntityList);
            return dictEntityList;
       }
        return null;
    }

}
