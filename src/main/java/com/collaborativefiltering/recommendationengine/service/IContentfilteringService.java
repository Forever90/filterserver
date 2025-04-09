package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Contentfiltering;

import java.util.List;

public interface IContentfilteringService {
    Contentfiltering selectContentfilteringById(Long id);

    List<Contentfiltering> selectContentfilteringList(Wrapper<Contentfiltering> queryWrapper);

    List<Contentfiltering> selectContentfilteringList(Contentfiltering contentfiltering);

    int insertContentfiltering(Contentfiltering contentfiltering);

    int updateContentfiltering(Contentfiltering contentfiltering);

    int deleteContentfilteringByIds(String ids);

    int deleteContentfilteringById(Long id);

    int updateVisible(Contentfiltering contentfiltering);
}
