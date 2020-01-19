package com.zlzc.modules.dictArea.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.dictArea.entity.DictAreaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地区字典表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-14 19:04:15
 */
@Mapper
public interface DictAreaDao extends BaseMapper<DictAreaEntity> {

    public List<DictAreaEntity> dictAreaByParentId(
            @Param(Constants.WRAPPER) Wrapper<DictAreaEntity> queryWrapper);
    public List<DictAreaEntity> dictAreaList(
            @Param(Constants.WRAPPER) Wrapper<DictAreaEntity> queryWrapper);

	
}
