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
 * 视频表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_content_video")
@Accessors(chain = true)
public class ContentVideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(name = "videoId", value = "ID", example = "001")
	private Long videoId;
	/**
	 * 评论id
	 */
	@ApiModelProperty(name = "commentId", value = "评论id", example = "001")
	private String commentId;
	/**
	 * 视频分类id
	 */
	@ApiModelProperty(name = "informationClassId", value = "视频分类id", example = "001")
	private String informationClassId;
	/**
	 * 视频编号
	 */
	@ApiModelProperty(name = "videoNumber", value = "视频编号", example = "6541asd")
	private String videoNumber;
	/**
	 * 视频标题
	 */
	@ApiModelProperty(name = "videoTitle", value = "视频标题", example = "xxx啊啊啊阿斯顿")
	private String videoTitle;
	/**
	 * 视频地址
	 */
	@ApiModelProperty(name = "videoAddress", value = "视频地址", example = "aaa/xxxx/1.mp4")
	private String videoAddress;
	/**
	 * 视频分类
	 */
	@ApiModelProperty(name = "videoContent", value = "视频分类", example = "001")
	private String videoContent;
	/**
	 * 视频点击量
	 */
	@ApiModelProperty(name = "videoClick", value = "视频点击量", example = "16513")
	private Integer videoClick;
	/**
	 * 收藏次数
	 */
	@ApiModelProperty(name = "videoFavorite", value = "收藏次数", example = "332")
	private Integer videoFavorite;
	/**
	 * 转发次数
	 */
	@ApiModelProperty(name = "videoForward", value = "转发次数", example = "233")
	private Integer videoForward;
	/**
	 * 分享次数
	 */
	@ApiModelProperty(name = "videoShareit", value = "分享次数", example = "465312")
	private Integer videoShareit;
	/**
	 * 视频发布时间
	 */
	@ApiModelProperty(name = "videoTime", value = "视频发布时间", example = "2020年1月14日17:27:08")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date videoTime;

}
