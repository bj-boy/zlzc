package com.zlzc.api.rest.content.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频资讯评论表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Data
@TableName("zlzc_content_comment")
@Accessors(chain = true)
public class ContentCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer commentId;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 回复内容
	 */
	private String commentReplyContent;
	/**
	 * 发表时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date commentTime;
	/**
	 * 删除标识
	 */
	private String commentDelete;

}
