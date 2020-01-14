package com.zlzc.api.rest.content.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.api.rest.commodity.entity.CommodityPriceEntity;
import com.zlzc.api.rest.commodity.entity.CommodityPriceMiddleEntity;
import com.zlzc.api.rest.content.entity.*;
import com.zlzc.api.rest.user.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 资讯
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
public class ContentLnformationVo extends ContentLnformationEntity implements Serializable{
    /**
     * 视频资讯分类
     */
    private ContentClassEntity contentClassEntity;
    /**
     * 视频资讯评论表
     */
    private ContentCommentEntity contentCommentEntity;
    /**
     * 视频资讯 商品关联表
     */
    private ContentNewsVideoCenterEntity contentNewsVideoCenterEntity;
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
