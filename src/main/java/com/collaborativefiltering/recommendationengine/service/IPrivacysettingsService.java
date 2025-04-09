package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacysettings;

import java.util.List;

public interface IPrivacysettingsService {
    Privacysettings selectPrivacysettingsById(Long id);

    List<Privacysettings> selectPrivacysettingsList(Wrapper<Privacysettings> queryWrapper);

    List<Privacysettings> selectPrivacysettingsList(Privacysettings privacysettings);

    int insertPrivacysettings(Privacysettings privacysettings);

    int updatePrivacysettings(Privacysettings privacysettings);

    int deletePrivacysettingsByIds(String ids);

    int deletePrivacysettingsById(Long id);

    int updateVisible(Privacysettings privacysettings);
}
