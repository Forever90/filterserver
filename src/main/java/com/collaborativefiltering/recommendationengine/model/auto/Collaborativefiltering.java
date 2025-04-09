package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private String userId;

    /** 物品id */
    @ApiModelProperty(value = "物品id" )
    private String goodsId;

    @ApiModelProperty(value = "评分")
    private String score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @ApiModelProperty(value = "时间戳")
    private Date timestamp;

    @ApiModelProperty(value = "相似度")
    private float similarity;

    @ApiModelProperty(value = "算法类型")
    private String algorithmType;

    @ApiModelProperty(value = "上下文信息")
    private String context;

    @ApiModelProperty(value = "权重")
    private float weight;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "数据来源")
    private String dataSource;

    @ApiModelProperty(value = "状态")
    private int status;
}
