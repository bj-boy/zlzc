package com.zlzc.modules.dictArea.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 功能描述:地区字典
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.dictArea.entity
 * @ClassName: DictAreaEntity
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/14 16:13
 * @Version: 1.0
 */
@Data
@TableName("zlzc_dict_area")
@Accessors(chain = true)
public class DictAreaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 地区ID
     */
    @ApiModelProperty(name = "albumId", value = "地区ID", example = "地区ID")
    @TableId
    private Long areaId;
    /**
     * 相册封面
     */
    @ApiModelProperty(name = "chame", value = "中文名称", example = "中文名称")
    private String chame;
    /**
     * 相册封面
     */
    @ApiModelProperty(name = "jname", value = "日文名称", example = "日文名称")
    private String jname;
    /**
     * 相册封面
     */
    @ApiModelProperty(name = "ename", value = "英文名称", example = "英文名称")
    private String ename;
    /**
     * 相册封面
     */
    @ApiModelProperty(name = "code", value = "编码", example = "编码")
    private String code;
    /**
     * 分组
     */
    @ApiModelProperty(name = "orderBy", value = "分组", example = "分组")
    @TableId
    private Long orderBy;
    /**
     * 父ID
     */
    @ApiModelProperty(name = "parentId", value = "父ID", example = "父ID")
    @TableId
    private Long parentId;

}
