package com.zlzc.modules.content.vo;


import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.entity.CommodityPriceMiddleEntity;
import com.zlzc.modules.content.entity.ContentClassEntity;
import com.zlzc.modules.content.entity.ContentCommentEntity;
import com.zlzc.modules.content.entity.ContentVideoEntity;
import com.zlzc.modules.user.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 视频
 */
@Data
public class VideoVo extends ContentVideoEntity implements Serializable{

    /**
     * 视频资讯分类
     */
    private ContentClassEntity contentClassEntity;
    /**
     * 视频资讯评论
     */
    private ContentCommentEntity contentCommentEntity;
    /**
     * 视频
     */
    private ContentVideoEntity contentVideoEntity;
    /**
     * 商品
     *
     */
    private CommodityEntity commodityEntity;
    /**
     * 价格
     */
    private CommodityPriceEntity commodityPriceEntity;
    /**
     * 商品价格中间表
     */
    private CommodityPriceMiddleEntity commodityPriceMiddleEntity;
    /**
     * 用户表
     */
    private UserEntity userEntity;

}
