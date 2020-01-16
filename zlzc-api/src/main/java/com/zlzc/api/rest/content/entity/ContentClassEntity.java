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
 * 视频资讯分类表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_content_class")
@Accessors(chain = true)
public class ContentClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "informationClassId", value = "ID", example = "001")
	private Integer informationClassId;
	/**
	 * 分类编号
	 */
	@ApiModelProperty(name = "informationClassNumber", value = "分类编号", example = "001")
	private String informationClassNumber;
	/**
	 * 分类图标
	 */
	@ApiModelProperty(name = "informationClassImg", value = "分类图标", example = "xxx/xxx/1.png")
	private String informationClassImg;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(name = "informationClassName", value = "分类名称", example = "资讯")
	private String informationClassName;
	/**
	 * 分类数量
	 */
	@ApiModelProperty(name = "informationClassQuantity", value = "分类数量", example = "200")
	private Integer informationClassQuantity;
	/**
	 * 是否显示
	 */
	@ApiModelProperty(name = "informationClassDisplay", value = "是否显示", example = "1")
	private String informationClassDisplay;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "informationClassTime", value = "创建时间", example = "2020-01-11 17:28:18")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date informationClassTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "informationClassRemark", value = "备注", example = "xxxxx")
	private String informationClassRemark;
	/**
	 * 资讯还是视频的分类
	 */
	@ApiModelProperty(name = "informationClassSelect", value = "资讯还是视频的分类", example = "1")
	private Integer informationClassSelect;
	/**
	 * 删除标识
	 */
	@ApiModelProperty(name = "informationClassDelete", value = "删除标识", example = "1")
	private Integer informationClassDelete;

}
