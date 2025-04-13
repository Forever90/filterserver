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

@TableName("dataencryption")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataencryption extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "协同id")
    private Long dataencryptionId;

    /** 加密名称 */
    @ApiModelProperty(value = "加密名称" )
    @TableField(value = "dateencryption_name")
    private String dataencryptionName;

    /** 加密算法 */
    @ApiModelProperty(value = "加密算法" )
    @TableField(value = "encryption_algorithm")
    private String encryptionAlgorithm;

    /** 密钥长度 */
    @ApiModelProperty(value = "密钥长度" )
    @TableField(value = "key_length")
    private Integer keyLength;

    /** 加密模式 */
    @ApiModelProperty(value = "加密模式" )
    @TableField(value = "encryption_mode")
    private String encryptionMode;

    /** 初始向量 */
    @ApiModelProperty(value = "初始向量" )
    @TableField(value = "original_vector")
    private String originalVector;

    /** 盐值 */
    @ApiModelProperty(value = "盐值" )
    @TableField(value = "salt")
    private String salt;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "create_at")
    private Date createdAt;

    /** 用户id */
    @ApiModelProperty(value = "更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "updated_at")
    private Date updatedAt;

    /** 状态 */
    @ApiModelProperty(value = "状态" )
    @TableField(value = "status")
    private String status;

    /** 描述 */
    @ApiModelProperty(value = "描述" )
    @TableField(value = "description")
    private String description;
}
