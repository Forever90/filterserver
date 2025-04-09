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
    private String userId;

    /** 审计日期 */
    @ApiModelProperty(value = "审计日期" )
    private String auditDate;

    /** 审计类型 */
    @ApiModelProperty(value = "审计类型" )
    private String auditType;

    /** 审计结果 */
    @ApiModelProperty(value = "审计结果" )
    private String auditResult;

    /** 审计状态 */
    @ApiModelProperty(value = "审计状态" )
    private String auditStatus;

    /** 审计备注 */
    @ApiModelProperty(value = "审计备注" )
    private String auditRemark;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间" )
    private Date createdAt;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间" )
    private Date updatedAt;

    /** 审计人 */
    @ApiModelProperty(value = "审计人" )
    private String auditor;
}
