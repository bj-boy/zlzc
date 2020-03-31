package com.zlzc.modules.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.modules.dict.entity.DictEntity;

import java.util.List;

public interface DictService  extends IService<DictEntity> {

    public List<DictEntity> getDict(String dictLabel);
    
    public List<DictEntity> getDictByDictLabel(String dictLabel);

    public boolean updDict(List<DictEntity> dictEntities);
}
