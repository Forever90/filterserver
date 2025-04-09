package com.collaborativefiltering.recommendationengine.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.collaborativefiltering.recommendationengine.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据匿名对象 dataanonymization
 */
@Data
@TableName("dataanonymization" )
public class Dataanonymization extends BaseEntity {
    private static final long serialVersionUID=1L;
    /** 匿名id */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "匿名id" )
    private Long dataanonymizationId;
    /** 匿名名称 */
    @ApiModelProperty(value = "匿名名称" )
    private String dataanonymizationName;
    /** 用户id */
    @ApiModelProperty(value = "用户id" )
    private String userId;
    /** 数据类型 */
    @ApiModelProperty(value = "数据类型" )
    private String dataType;
    /** 匿名方法 */
    @ApiModelProperty(value = "匿名方法" )
    private String anonymizationMethod;
    /** 匿名级别 */
    @ApiModelProperty(value = "匿名级别" )
    private String anonymizationLevel;
    /** 匿名日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @ApiModelProperty(value = "匿名日期" )
    private Date anonymizationDate;
    /** 匿名状态 */
    @ApiModelProperty(value = "匿名状态" )
    private String anonymizationStatus;
    /** 匿名备注 */
    @ApiModelProperty(value = "匿名备注" )
    private String anonymizationNote;
    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    private String createdAt;
    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    private String updatedAt;
}
