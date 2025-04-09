package com.collaborativefiltering.recommendationengine.model.auto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privacysettings {

    private String privacysettingsId;

    private String userId;

    private String profileVisibility;

    private String postVisibility;

    private String messagePermission;

    private String friendRequests;

    private String locationSharing;

    private String lastUpdated;

    private String emailNotifications;

    private String pushNotifications;

    private String dataSharing;

    private String customPrivacyGroup;

    private String twoFactorAuth;
}
