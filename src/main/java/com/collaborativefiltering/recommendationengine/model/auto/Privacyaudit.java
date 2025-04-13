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
@TableName("privacyaudit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privacyaudit extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "审计id")
    private Long privacyauditId;

    /** 用户id */
    @ApiModelProperty(value = "用户id" )
    @TableField(value = "user_id")
    private String userId;

    /** 审计日期 */
    @ApiModelProperty(value = "审计日期" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "audit_date")
    private String auditDate;

    /** 审计类型 */
    @ApiModelProperty(value = "审计类型" )
    @TableField(value = "audit_type")
    private String auditType;

    /** 审计结果 */
    @ApiModelProperty(value = "审计结果" )
    @TableField(value = "audit_result")
    private String auditResult;

    /** 审计状态 */
    @ApiModelProperty(value = "审计状态" )
    @TableField(value = "audit_status")
    private String auditStatus;

    /** 审计备注 */
    @ApiModelProperty(value = "审计备注" )
    @TableField(value = "audit_remark")
    private String auditRemark;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "created_at")
    private Date createdAt;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "updated_at")
    private Date updatedAt;

    /** 审计人 */
    @ApiModelProperty(value = "审计人" )
    @TableField(value = "auditor")
    private String auditor;
}
