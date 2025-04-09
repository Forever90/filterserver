package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.collaborativefiltering.recommendationengine.model.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("recommendationengine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendationengine extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "推荐引擎id")
    private long recommendationenginId;

    @ApiModelProperty(value = "推荐引擎名称")
    private String recommendationengineName;

    @ApiModelProperty(value = "算法类型")
    private String algorithmType;

    @ApiModelProperty(value = "创建时间")
    private Date createdAt;

    @ApiModelProperty(value = "更新时间")
    private Date updatedAt;

    @ApiModelProperty(value = "状态")
    private int status;
    /** 描述 */
    @ApiModelProperty(value = "描述" )
    private String description;

    @ApiModelProperty(value = "用户id" )
    private String userId;
    /** 优先级 */
    @ApiModelProperty(value = "优先级" )
    private String priority;
}
