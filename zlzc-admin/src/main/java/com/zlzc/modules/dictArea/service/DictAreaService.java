package com.zlzc.modules.dictArea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.modules.dictArea.entity.DictAreaEntity;

import java.util.List;

/**
 * 地区字典表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-14 19:04:15
 */

public interface DictAreaService extends IService<DictAreaEntity> {
    List<DictAreaEntity> dictAreaByParentId(Long parentId);
    List<DictAreaEntity> dictAreaList(Long parentId);
}

