package com.zlzc.modules.dict.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.modules.dict.entity.DictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictDao extends BaseMapper<DictEntity> {

    public List<String> xxx();

}
