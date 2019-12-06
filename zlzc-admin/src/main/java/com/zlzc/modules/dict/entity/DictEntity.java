package com.zlzc.modules.dict.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.jnlp.IntegrationService;
import java.io.Serializable;
import java.util.Date;

/**
 * 字典表
 */
@ApiModel(description = "字典实体")
@Data
@TableName("zezl_dict")
public class DictEntity implements Serializable {
    /**
     * 字典id
     */
    @ApiModelProperty(name = "dictId", value = "字典id", example = "001")
    @TableId
    private  Long  dictId;
    /**
     * 数据值
     */
    @ApiModelProperty(name = "dictValue", value = "数据值", example = "")
    private  String dictValue;
    /**
     * 标签名
     */
    @ApiModelProperty(name = "dictLabel", value = "标签名", example = "")
    private  String   dictLabel;
    /**
     *类型
     */
    @ApiModelProperty(name = "dictType", value = "类型", example = "")
    private  String   dictType;
    /**
     * 描述
     */
    @ApiModelProperty(name = "dictDescription", value = "描述", example = "")
    private String  dictDescription;
    /**
     * 排序
     */
    @ApiModelProperty(name = "dictSort", value = "排序", example = "")
    private Integer dictSort;
    /**
     * 父级编号
     */
    @ApiModelProperty(name = "dictParentId", value = "父级编号", example = "")
    private String  dictParentId;
    /**
     * 创建者
     */
    @ApiModelProperty(name = "dictCreateBy", value = "创建者", example = "")
    private String  dictCreateBy;
    /**
     * 创建日期
     */
    @ApiModelProperty(name = "dictCreateDate", value = "创建日期", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   dictCreateDate;
    /**
     * 更新者
     */
    @ApiModelProperty(name = "dictUpdateBy", value = "更新者", example = "")
    private String  dictUpdateBy;
    /**
     * 更新日期
     */
    @ApiModelProperty(name = "dictUpdateDate", value = "更新日期", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  Date   dictUpdateDate;
    /**
     * 备注
     */
    @ApiModelProperty(name = "dictRemarks", value = "备注", example = "")
    private  String   dictRemarks;
    /**
     * 删除标志
     */
    @ApiModelProperty(name = "dictDelFlag", value = "删除标志", example = "")
    private  String   dictDelFlag;

}
