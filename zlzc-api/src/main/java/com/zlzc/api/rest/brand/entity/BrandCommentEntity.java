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
 * 品牌评价表
 */
@Data
@TableName("zlzc_brand_comment")
@Accessors(chain = true)
public class BrandCommentEntity {

    /**
     * 品牌评价id
     */
    @ApiModelProperty(name = "brandCommentId", value = "品牌评价id", example = "1")
    @TableId
    private Long brandCommentId;

    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id", example = "1")
    private Long userId;

    /**
     * 回复内容
     */
    @ApiModelProperty(name = "brandReplyContent", value = "回复内容", example = "xxxx品牌真是好 好用好用")
    private  String brandReplyContent;

    /**
     *发表时间
     */
    @ApiModelProperty(name = "brandTime", value = "发表时间", example = "2020年1月11日17:54:43")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date brandTime;

    /**
     *删除标识
     */
    @ApiModelProperty(name = "brandDelete", value = "删除标识", example = "1")
    private Integer brandDelete;

}
