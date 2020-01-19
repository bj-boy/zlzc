package com.zlzc.modules.ad.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_ad")
@Accessors(chain = true)
public class AdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "adId", value = "ID", example = "001")
	private Long adId;
	/**
	 * 编号
	 */
	@ApiModelProperty(name = "adNumber", value = "编号", example = "0001")
	private Long adNumber;
	/**
	 * 广告名称
	 */
	@ApiModelProperty(name = "adName", value = "广告名称", example = "活动xxxx减免")
	private String adName;
	/**
	 * 广告位置
	 */
	@ApiModelProperty(name = "adPosition", value = "广告位置", example = "1")
	private Integer adPosition;
	/**
	 * 广告图片
	 */
	@ApiModelProperty(name = "adImage", value = "广告图片", example = "aaa/aaa/a.png")
	private String adImage;
	/**
	 * 点击次数
	 */
	@ApiModelProperty(name = "adCount", value = "点击次数", example = "10000")
	private Integer adCount;
	/**
	 * 生产订单数
	 */
	@ApiModelProperty(name = "adOddNumber", value = "生产订单数", example = "2000")
	private Integer adOddNumber;
	/**
	 * 广告连接
	 */
	@ApiModelProperty(name = "adConnection", value = "广告连接", example = "aa/555/3.html")
	private String adConnection;
	/**
	 * 广告备注
	 */
	@ApiModelProperty(name = "adRemark", value = "广告备注", example = "aaxxxxxxx")
	private String adRemark;
	/**
	 * 开始时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "adStart", value = "开始时间", example = "2020-01-13 16:20:46")
	private Date adStart;
	/**
	 * 结束时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "adEnd", value = "结束时间", example = "2020-01-13 16:21:00")
	private Date adEnd;
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "adCreate", value = "创建时间", example = "2020-01-13 16:21:11")
	private Date adCreate;
	/**
	 * 删除标识
	 */
	@ApiModelProperty(name = "adDelete", value = "删除标识", example = "1")
	private String adDelete;

}
