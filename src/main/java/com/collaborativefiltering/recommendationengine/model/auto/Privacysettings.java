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

@TableName("privacysettings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privacysettings extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "隐私设置id")
    private Long privacysettingsId;

    /** 用户id */
    @ApiModelProperty(value = "用户id" )
    private String userId;

    /** 个人资料可见性 */
    @ApiModelProperty(value = "个人资料可见性" )
    private String profileVisibility;

    /** 帖子可见性 */
    @ApiModelProperty(value = "帖子可见性" )
    private String postVisibility;

    /** 消息权限 */
    @ApiModelProperty(value = "消息权限" )
    private String messagePermission;

    /** 好友请求 */
    @ApiModelProperty(value = "好友请求" )
    private String friendRequests;

    /** 好友请求 */
    @ApiModelProperty(value = "位置贡献" )
    private String locationSharing;

    /** 最后更新实践 */
    @ApiModelProperty(value = "最后更新时间" )
    private String lastUpdated;

    /** 邮件通知 */
    @ApiModelProperty(value = "邮件通知" )
    private String emailNotifications;

    /** 推送通知 */
    @ApiModelProperty(value = "推送通知" )
    private String pushNotifications;

    /** 数据共享 */
    @ApiModelProperty(value = "数据共享" )
    private String dataSharing;

    /** 自定义隐私组 */
    @ApiModelProperty(value = "自定义隐私组" )
    private String customPrivacyGroup;

    /** 两步验证 */
    @ApiModelProperty(value = "两步验证" )
    private String twoFactorAuth;
}
