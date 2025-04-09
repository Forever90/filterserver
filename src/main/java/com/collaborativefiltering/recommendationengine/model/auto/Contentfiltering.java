package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class Contentfiltering extends BaseEntity{
    private static final long serialVersionUID=1L;
    /** 过滤id */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "过滤id" )
    private Long contentfilteringId;
    /** 过滤名称 */
    @ApiModelProperty(value = "过滤名称" )
    private String contentfilteringName;
    /** 过滤类型 */
    @ApiModelProperty(value = "过滤类型" )
    private String filterType;
    /** 过滤规则 */
    @ApiModelProperty(value = "过滤规则" )
    private String filterRule;
    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    private String createdAt;
    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    private String updatedAt;
    /** 状态 */
    @ApiModelProperty(value = "状态" )
    private String status;
    /** 描述 */
    @ApiModelProperty(value = "描述" )
    private String description;
    /** 优先级 */
    @ApiModelProperty(value = "优先级" )
    private String priority;
}