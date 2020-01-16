package com.zlzc.api.rest.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.dict.entity.DictEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DictService  extends IService<DictEntity> {

    public List<DictEntity> getDict(String dictLabel);
}
