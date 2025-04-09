package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacyaudit;

import java.util.List;

public interface IPrivacyauditService {
    Privacyaudit selectPrivacyauditById(Long id);

    List<Privacyaudit> selectPrivacyauditList(Wrapper<Privacyaudit> queryWrapper);

    List<Privacyaudit> selectPrivacyauditList(Privacyaudit privacyaudit);

    int insertPrivacyaudit(Privacyaudit privacyaudit);

    int updatePrivacyaudit(Privacyaudit privacyaudit);

    int deletePrivacyauditByIds(String ids);

    int deletePrivacyauditById(Long id);

    int updateVisible(Privacyaudit privacyaudit);
}
