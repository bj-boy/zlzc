package com.zlzc.api.rest.content.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_content_news_video_center")
@Accessors(chain = true)
public class ContentNewsVideoCenterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long newsVideoCenterId;
	/**
	 * 资讯id
	 */
	private String informationId;
	/**
	 * 视频id
	 */
	private String videoId;
	/**
	 * 商品id
	 */
	private String commodityId;

}
