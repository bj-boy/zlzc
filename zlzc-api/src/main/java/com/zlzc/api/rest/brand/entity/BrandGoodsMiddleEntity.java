package com.zlzc.api.rest.brand.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌商品关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_brand_goods_middle")
public class BrandGoodsMiddleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long brandGoodsMiddleId;
    /**
     * 品牌的id
     */
    private Long brandId;
    /**
     * 商品的id
     */
    private Long commodityId;

}
