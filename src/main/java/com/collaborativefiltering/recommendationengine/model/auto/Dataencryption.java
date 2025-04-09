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
    private String dataencryptionName;

    /** 加密算法 */
    @ApiModelProperty(value = "加密算法" )
    private String encryptionAlgorithm;

    /** 密钥长度 */
    @ApiModelProperty(value = "密钥长度" )
    private Integer keyLength;

    /** 加密模式 */
    @ApiModelProperty(value = "加密模式" )
    private String encryptionMode;

    /** 初始向量 */
    @ApiModelProperty(value = "初始向量" )
    private String originalVector;

    /** 盐值 */
    @ApiModelProperty(value = "盐值" )
    private String salt;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    private Date createdAt;

    /** 用户id */
    @ApiModelProperty(value = "更新时间" )
    private Date updatedAt;

    /** 状态 */
    @ApiModelProperty(value = "状态" )
    private String status;

    /** 描述 */
    @ApiModelProperty(value = "描述" )
    private String desc;
}
