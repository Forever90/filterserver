package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.collaborativefiltering.recommendationengine.model.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 内容过滤对象 contentfiltering
 */
@TableName("contentfiltering" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contentfiltering extends BaseEntity {
    private static final long serialVersionUID=1L;
    /** 过滤id */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "过滤id" )
    private Long contentfilteringId;
    /** 过滤名称 */
    @ApiModelProperty(value = "过滤名称" )
    @TableField(value = "contentfiltering_name")
    private String contentfilteringName;
    /** 过滤类型 */
    @ApiModelProperty(value = "过滤类型" )
    @TableField(value = "filter_type")
    private String filterType;
    /** 过滤规则 */
    @ApiModelProperty(value = "过滤规则" )
    @TableField(value = "filter_rule")
    private String filterRule;
    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    @TableField(value = "created_at")
    private String createdAt;
    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    @TableField(value = "updated_at")
    private String updatedAt;
    /** 状态 */
    @ApiModelProperty(value = "状态" )
    @TableField(value = "status")
    private String status;
    /** 描述 */
    @ApiModelProperty(value = "描述" )
    @TableField(value = "description")
    private String description;
    /** 优先级 */
    @ApiModelProperty(value = "优先级" )
    @TableField(value = "priority")
    private String priority;
}