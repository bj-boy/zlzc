package com.zlzc.api.rest.brand.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌店铺关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_brand_middle_shop")
public class BrandMiddleShopEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long  brandMiddleShopId;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 品牌id
     */
    private Long brandId;

}