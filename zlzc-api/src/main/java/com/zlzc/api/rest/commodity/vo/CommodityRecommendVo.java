package com.zlzc.api.rest.commodity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zlzc.api.rest.commodity.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品-推荐
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityRecommendVo extends CommodityRecommendEntity implements Serializable {
    /**
     * 商品对象
     */

    private CommodityEntity commodityEntity;
    /**
     * 价格表
     */
    private CommodityPriceEntity commodityPriceEntity;
    /**
     * 价格中间表
     */
    private CommodityPriceMiddleEntity commodityPriceMiddleEntity;

}
