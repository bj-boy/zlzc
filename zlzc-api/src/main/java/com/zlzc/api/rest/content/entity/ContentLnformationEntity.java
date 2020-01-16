package com.zlzc.api.rest.content.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_content_lnformation")
@Accessors(chain = true)
public class ContentLnformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "informationId", value = "ID", example = "001")
	private Long informationId;
	/**
	 * 评论id
	 */
	@ApiModelProperty(name = "commentId", value = "评论id", example = "001")
	private Long commentId;
	/**
	 * 资讯分类id

	 */
	@ApiModelProperty(name = "informationClassId", value = "资讯分类id", example = "001")
	private String informationClassId;
	/**
	 * 资讯编号
	 */
	@ApiModelProperty(name = "informationNumber", value = "资讯编号", example = "001")
	private String informationNumber;
	/**
	 * 资讯图片
	 */
	@ApiModelProperty(name = "informationImage", value = "资讯图片 ｛ww/sss/aa/1.pnj , ww/sss/aa/1.pnj｝", example = "ww/sss/aa/1.pnj")
	private String informationImage;
	/**
	 * 资讯标题
	 */
	@ApiModelProperty(name = "informationTitle", value = "资讯标题", example = "xxxxaaaaaa")
	private String informationTitle;
	/**
	 * 资讯推荐
	 */
	@ApiModelProperty(name = "informationRecommend", value = "资讯推荐", example = "1")
	private String informationRecommend;
	/**
	 * 资讯收藏数
	 */
	@ApiModelProperty(name = "informationFavorites", value = "资讯收藏数", example = "3250")
	private Long informationFavorites;
	/**
	 * 资讯转发数
	 */
	@ApiModelProperty(name = "informationForwards", value = "资讯转发数", example = "33366")
	private Integer informationForwards;
	/**
	 * 资讯阅读数
	 */
	@ApiModelProperty(name = "informationReda", value = "资讯阅读数", example = "636362")
	private Integer informationReda;
	/**
	 * 资讯发布时间
	 */
	@ApiModelProperty(name = "informationTime", value = "资讯发布时间", example = "2020-01-13 18:02:30")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date informationTime;
	/**
	 * 资讯创建时间
	 */
	@ApiModelProperty(name = "informationCreateTime", value = "资讯创建时间", example = "2020-01-13 18:02:30")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date informationCreateTime;
	/**
	 * 删除标识
	 */
	@ApiModelProperty(name = "informationDelete", value = "删除标识", example = "1")
	private Integer informationDelete;

}
