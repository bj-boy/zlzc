package com.zlzc.modules.content.vo;

import com.zlzc.modules.content.entity.ContentClassEntity;
import com.zlzc.modules.content.entity.ContentLnformationEntity;
import lombok.Data;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.content.vo
 * @ClassName: contentlnSaveVo
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/19 15:47
 * @Version: 1.0
 */
@Data
public class ContentlnSaveVo {
    /**
     * 咨询
     */
   private ContentLnformationEntity contentLnformationEntity;
    /**
     * 分类
     */
    private ContentClassEntity  contentClassEntity;
}
