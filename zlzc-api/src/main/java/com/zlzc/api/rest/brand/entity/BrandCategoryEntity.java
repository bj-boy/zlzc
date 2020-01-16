package com.zlzc.api.rest.brand.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import sun.dc.pr.PRError;

import java.util.Date;

/**
 * 品牌分类表
 */
@Data
@TableName("zlzc_brand_category")
@Accessors(chain = true)
public class BrandCategoryEntity {
    /**
     * 分类ID
     */
    @ApiModelProperty(name = "brandCategoryId", value = "分类ID", example = "1")
    @TableId
    private Long brandCategoryId;
    /**
     *品牌分类名称·
     */
    @ApiModelProperty(name = "brandCategoryName", value = "品牌分类名称", example = "五金")
    private String brandCategoryName;

    /**
     *品牌分类图标
     */
    @ApiModelProperty(name = "brandCategoryIcon", value = "品牌分类图标", example = "/aaa/xxx/xx")
    private String brandCategoryIcon;

    /**
     *品牌数量
     */
    @ApiModelProperty(name = "brandCategoryQuantity", value = "品牌数量", example = "2200")
    private  Integer brandCategoryQuantity;

    /**
     * 是否显示
     */
    @ApiModelProperty(name = "brandCategoryDisplay", value = "是否显示", example = "1")
    private Integer brandCategoryDisplay;

    /**
     * 排序
     */
    @ApiModelProperty(name = "brandCategorySort", value = "排序", example = "200")
    private  Integer  brandCategorySort;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "brandCategoryTime", value = "创建时间", example = "2020-01-11 17:39:01")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date brandCategoryTime;

    /**
     * 删除标识
     */
    @ApiModelProperty(name = "brandCategoryDelete", value = "删除标识", example = "1")
    private Integer brandCategoryDelete;

}
