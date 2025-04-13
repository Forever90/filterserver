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


@TableName("collaborativefiltering" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collaborativefiltering extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "协同id")
    private Long collaborativefilteringId;

    /** 用户id */
    @ApiModelProperty(value = "用户id" )
    @TableField(value = "user_id")
    private String userId;

    /** 物品id */
    @ApiModelProperty(value = "物品id" )
    @TableField(value = "goods_id")
    private String goodsId;

    @ApiModelProperty(value = "评分")
    @TableField(value = "score")
    private String score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @ApiModelProperty(value = "时间戳")
    @TableField(value = "timestamp")
    private Date timestamp;

    @ApiModelProperty(value = "相似度")
    @TableField(value = "similarity")
    private float similarity;

    @ApiModelProperty(value = "算法类型")
    @TableField(value = "algorithm_type")
    private String algorithmType;

    @ApiModelProperty(value = "上下文信息")
    @TableField(value = "context")
    private String context;

    @ApiModelProperty(value = "权重")
    @TableField(value = "weight")
    private float weight;

    @ApiModelProperty(value = "类别")
    @TableField(value = "category")
    private String category;

    @ApiModelProperty(value = "数据来源")
    @TableField(value = "datasource")
    private String dataSource;

    @ApiModelProperty(value = "状态")
    @TableField(value = "status")
    private int status;
}
