package com.zlzc.api.rest.brand.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.Date;

/**
 * 品牌表
 */
@Data
@TableName("zlzc_brand")
@Accessors(chain = true)
public class BrandEntity  implements Serializable {
    /**
     * 品牌ID
     *
     */
    @ApiModelProperty(name = "brandId", value = "品牌ID", example = "1")
    @TableId
    private Long brandId;
    /**
     * 品牌分类id
     */
    @ApiModelProperty(name = "brandCategoryId", value = "品牌分类id", example = "1")
    private Long brandCategoryId;
    /**
     * 品牌分类id
     */
    @ApiModelProperty(name = "brandCommentId", value = "品牌评论id", example = "1")
    private Long brandCommentId;

    /**
     * 品牌编号
     */
    @ApiModelProperty(name = "brandNumber", value = "品牌编号", example = "AAA34121634512")
    private String brandNumber;

    /**
     * 品牌名称
      */
    @ApiModelProperty(name = "brandName", value = "品牌名称", example = "xxx品牌")
    private  String brandName;

    /**
     * 品牌logo
     */
    @ApiModelProperty(name = "brandLogo", value = "品牌logo", example = "/aaa/xxx")
    private  String brandLogo;

    /**
     * 品牌介绍
      */
    @ApiModelProperty(name = "brandIntroduction", value = "品牌介绍", example = "这是一个超大的品牌")
    private String brandIntroduction;

    /**
     * 品牌首字母
     */
    @ApiModelProperty(name = "brandIntroduction", value = "品牌首字母", example = "B")
    private String brandInitials;


    /**
     * 品牌所在地区
     */
    @ApiModelProperty(name = "brandArea", value = "品牌所在地区", example = "中国")
    private String brandArea;
    /**
     * 品牌排序
     */
    @ApiModelProperty(name = "brandSort", value = "品牌排序", example = "50")
    private Integer brandSort;

    /**
     * 品牌推荐
     */
    @ApiModelProperty(name = "brandRecommend", value = "品牌推荐", example = "1")
    private Integer brandRecommend;

    /**
     * 品牌制造商
     */
    @ApiModelProperty(name = "brandManufacturer", value = "品牌制造商", example = "XXX制造商")
    private String brandManufacturer;

    /**
     * 是否显示
     */
    @ApiModelProperty(name = "brandDisplay", value = "是否显示", example = "1")
    private Integer brandDisplay;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "brandTime", value = "创建时间", example = "2020-01-11 17:28:18")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date brandTime;

    /**
     * 备注
     */
    @ApiModelProperty(name = "brandRemark", value = "备注", example = "刚刚加入本平台")
    private String brandRemark;

    /**
     * 删除标识
     */
    @ApiModelProperty(name = "brandDelete", value = "删除标识", example = "1")
    private Integer brandDelete;

}
