package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Recommendationengine;

import java.util.List;

public interface IRecommendationengineService {
    Recommendationengine selectRecommendationengineById(Long id);

    List<Recommendationengine> selectRecommendationengineList(Wrapper<Recommendationengine> queryWrapper);

    List<Recommendationengine> selectRecommendationengineList(Recommendationengine recommendationengine);

    int insertRecommendationengine(Recommendationengine recommendationengine);

    int updateRecommendationengine(Recommendationengine recommendationengine);

    int deleteRecommendationengineByIds(String ids);

    int deleteRecommendationengineById(Long id);

    int updateVisible(Recommendationengine recommendationengine);
}
