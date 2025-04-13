package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.collaborativefiltering.recommendationengine.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long recommendationenginId;

    @ApiModelProperty(value = "推荐引擎名称")
    @TableField(value = "recommendationengine_name")
    private String recommendationengineName;

    @ApiModelProperty(value = "算法类型")
    @TableField(value = "algorithm_type")
    private String algorithmType;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "created_at")
    private Date createdAt;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "updated_at")
    private Date updatedAt;

    @ApiModelProperty(value = "状态")
    @TableField(value = "status")
    private int status;
    /** 描述 */
    @ApiModelProperty(value = "描述" )
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "用户id" )
    @TableField(value = "user_id")
    private String userId;
    /** 优先级 */
    @ApiModelProperty(value = "优先级" )
    @TableField(value = "priority")
    private String priority;
}
