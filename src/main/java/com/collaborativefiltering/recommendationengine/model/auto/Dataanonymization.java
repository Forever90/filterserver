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

import java.io.Serializable;
import java.util.Date;

/**
 * 数据匿名对象 dataanonymization
 */
@TableName("dataanonymization" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataanonymization extends BaseEntity {
    private static final long serialVersionUID=1L;
    /** 匿名id */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "匿名id" )
    private Long dataanonymizationId;
    /** 匿名名称 */
    @ApiModelProperty(value = "匿名名称" )
    @TableField(value = "dataanonymization_name")
    private String dataanonymizationName;
    /** 用户id */
    @ApiModelProperty(value = "用户id" )
    @TableField(value = "user_id")
    private String userId;
    /** 数据类型 */
    @ApiModelProperty(value = "数据类型" )
    @TableField(value = "data_type")
    private String dataType;
    /** 匿名方法 */
    @ApiModelProperty(value = "匿名方法" )
    @TableField(value = "anonymization_method")
    private String anonymizationMethod;
    /** 匿名级别 */
    @ApiModelProperty(value = "匿名级别" )
    @TableField(value = "anonymization_level")
    private String anonymizationLevel;
    /** 匿名日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @ApiModelProperty(value = "匿名日期" )
    @TableField(value = "date")
    private Date anonymizationDate;
    /** 匿名状态 */
    @ApiModelProperty(value = "匿名状态" )
    @TableField(value = "anonymization_status")
    private String anonymizationStatus;
    /** 匿名备注 */
    @ApiModelProperty(value = "匿名备注" )
    @TableField(value = "anonymization_note")
    private String anonymizationNote;
    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "created_at")
    private String createdAt;
    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "updated_at")
    private String updatedAt;
}
