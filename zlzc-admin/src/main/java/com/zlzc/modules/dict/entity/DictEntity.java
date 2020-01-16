package com.zlzc.modules.dict.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表
 */
@ApiModel(description = "字典实体")
@Data
@TableName("zlzc_dict")
public class DictEntity implements Serializable {
    /**
     * 字典id
     */
    @ApiModelProperty(name = "dictId", value = "字典id", example = "字典id")
    @TableId
    private  Long  dictId;
    /**
     * 数据值
     */
    @ApiModelProperty(name = "dictValue", value = "数据值", example = "数据值")
    private  String dictValue;
    /**
     * 标签名
     */
    @ApiModelProperty(name = "dictLabel", value = "标签名", example = "dictLabel")
    private  String   dictLabel;
    /**
     *类型
     */
    @ApiModelProperty(name = "dictType", value = "类型", example = "类型")
    private  String   dictType;
    /**
     * 描述
     */
    @ApiModelProperty(name = "dictDescription", value = "描述", example = "描述")
    private String  dictDescription;
    /**
     * 排序
     */
    @ApiModelProperty(name = "dictSort", value = "排序", example = "排序")
    private Integer dictSort;
    /**
     * 父级编号
     */
    @ApiModelProperty(name = "dictParentId", value = "父级编号", example = "父级编号")
    private String  dictParentId;
    /**
     * 创建者
     */
    @ApiModelProperty(name = "dictCreateBy", value = "创建者", example = "创建者")
    private String  dictCreateBy;
    /**
     * 创建日期
     */
    @ApiModelProperty(name = "dictCreateDate", value = "创建日期", example = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date   dictCreateDate;
    /**
     * 更新者
     */
    @ApiModelProperty(name = "dictUpdateBy", value = "更新者", example = "更新者")
    private String  dictUpdateBy;
    /**
     * 更新日期
     */
    @ApiModelProperty(name = "dictUpdateDate", value = "更新日期", example = "更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private  Date   dictUpdateDate;
    /**
     * 备注
     */
    @ApiModelProperty(name = "dictRemarks", value = "备注", example = "备注")
    private  String   dictRemarks;
    /**
     * 删除标志
     */
    @ApiModelProperty(name = "dictDelFlag", value = "删除标志", example = "删除标志")
    private  String   dictDelFlag;

}
