package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacypolicies;

import java.util.List;

public interface IPrivacypoliciesService {
    Privacypolicies selectPrivacypoliciesById(Long id);

    List<Privacypolicies> selectPrivacypoliciesList(Wrapper<Privacypolicies> queryWrapper);

    List<Privacypolicies> selectPrivacypoliciesList(Privacypolicies privacypolicies);

    int insertPrivacypolicies(Privacypolicies privacypolicies);

    int updatePrivacypolicies(Privacypolicies privacypolicies);

    int deletePrivacypoliciesByIds(String ids);

    int deletePrivacypoliciesById(Long id);

    int updateVisible(Privacypolicies privacypolicies);
}
