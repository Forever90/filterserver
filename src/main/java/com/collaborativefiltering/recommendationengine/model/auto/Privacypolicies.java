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

@TableName("privacypolicies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privacypolicies extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "隐私政策id")
    private Long privacypoliciesId;

    /** 政策名称 */
    @ApiModelProperty(value = "政策名称" )
    @TableField(value = "policy_name")
    private String policyName;

    /** 版本号 */
    @ApiModelProperty(value = "版本号" )
    @TableField(value = "version")
    private String version;

    /** 生效日期 */
    @ApiModelProperty(value = "生效日期" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "effective_date")
    private Date effectiveDate;

    /** 用户id */
    @ApiModelProperty(value = "政策描述" )
    @TableField(value = "policied_desc")
    private String policiesDesc;

    /** 最后更新时间 */
    @ApiModelProperty(value = "最后更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8" )
    @TableField(value = "last_updated")
    private Date lastUpdated;

    /** 作者 */
    @ApiModelProperty(value = "作者" )
    @TableField(value = "author")
    private String author;

    /** 状态 */
    @ApiModelProperty(value = "状态" )
    @TableField(value = "status")
    private String status;

    /** 语言 */
    @ApiModelProperty(value = "语言" )
    @TableField(value = "language")
    private String language;

    /** 国家 */
    @ApiModelProperty(value = "国家" )
    @TableField(value = "country")
    private String country;

    /** 合规级别 */
    @ApiModelProperty(value = "合规级别" )
    @TableField(value = "compliance_level")
    private String complianceLevel;
}
