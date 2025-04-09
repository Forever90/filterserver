package com.collaborativefiltering.recommendationengine.model.auto;

import lombok.Data;

@Data
public class Privacyaudit {

    private String userId;

    private String auditDate;

    private String updatedAt;

    private String auditType;

    private String auditResult;

    private String auditStatus;
}
