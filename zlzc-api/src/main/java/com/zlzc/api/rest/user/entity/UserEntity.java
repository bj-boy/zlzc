package com.zlzc.api.rest.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("zlzc_user")

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(name = "userId", value = "ID", example = "1")
    private Long userId;
    /**
     * 用户名
     */
    @ApiModelProperty(name = "username", value = "用户名", example = "理想型")
    private String username;
    /**
     * 用户账号
     */
    @ApiModelProperty(name = "userAcct", value = "用户账号", example = "1845132")
    private String userAcct;
    /**
     * 用户密码
     */
    @ApiModelProperty(name = "userPassword", value = "用户密码", example = "3214432")
    private String userPassword;
    /**
     * 手机号
     */
    @ApiModelProperty(name = "mobile", value = "手机号", example = "12345412")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(name = "email", value = "邮箱", example = "4351asd@qq.com")
    private String email;
    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty(name = "userStatus", value = "状态  0：禁用   1：正常", example = "1")
    private Integer userStatus;
    /**
     * 性别  0：未知   1：男   2：女
     */
    @ApiModelProperty(name = "gender", value = "性别  0：未知   1：男   2：女", example = "1")
    private Integer gender;
    /**
     * 生日
     */
    @ApiModelProperty(name = "birthday", value = "生日", example = "2020-01-13 18:02:30")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    /**
     * 城市
     */
    @ApiModelProperty(name = "address", value = "城市", example = "北京市")
    private String address;
    /**
     * 个性签名
     */
    @ApiModelProperty(name = "signature", value = "个性签名", example = "xxxxxxx")
    private String signature;
    /**
     * 职业
     */
    @ApiModelProperty(name = "profession", value = "职业", example = "医生")
    private String profession;
    /**
     * 头像
     */
    @ApiModelProperty(name = "img", value = "头像", example = "xxxx/xxx/l.png")
    private String img;
    /**
     * 喜欢的分类，多个用逗号分隔
     */
    @ApiModelProperty(name = "favouriteCategory", value = "喜欢的分类，多个用逗号分隔", example = "打游戏，听歌")
    private String favouriteCategory;
    /**
     * 来源  0：未知   1：app   2：admin
     */
    @ApiModelProperty(name = "source", value = "来源  0：未知   1：app   2：admin", example = "1")
    private Integer source;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2020年1月14日16:04:47")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", value = "更新时间", example = "2020年1月14日16:04:57")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 操作人
     */
    @ApiModelProperty(name = "operator", value = "操作人", example = "李某某")
    private String operator;

}
