package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@TableName("zlzc_commodity_album")
@Accessors(chain = true)
public class CommodityAlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "albumId", value = "相册ID", example = "相册ID")
	@TableId
	private Long albumId;
	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "商户ID")
	private Long merchantId;
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(name = "shopId", value = "店铺ID", example = "店铺ID")
	private Long shopId;
	/**
	 * 品牌ID
	 */
	@ApiModelProperty(name = "brandId", value = "品牌ID", example = "品牌ID")
	private Long brandId;
	/**
	 * 相册编号
	 */
	@ApiModelProperty(name = "albumNo", value = "相册编号", example = "相册编号")
	private Long albumNo;
	/**
	 * 相册名称
	 */
	@ApiModelProperty(name = "albumName", value = "相册名称", example = "相册名称")
	private String albumName;
	/**
	 * 相册描述
	 */
	@ApiModelProperty(name = "albumDesc", value = "相册描述", example = "相册描述")
	private String albumDesc;
	/**
	 * 相册封面
	 */
	@ApiModelProperty(name = "albumCoverUrl", value = "相册封面", example = "相册封面")
	private String albumCoverUrl;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;

}
