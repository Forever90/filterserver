package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Collaborativefiltering;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICollaborativefilteringService {

    Collaborativefiltering selectCollaborativefilteringById(Long id);

    List<Collaborativefiltering> selectCollaborativefilteringList(Wrapper<Collaborativefiltering> queryWrapper);

    List<Collaborativefiltering> selectCollaborativefilteringList(Collaborativefiltering collaborativefiltering);

    int insertCollaborativefiltering(Collaborativefiltering collaborativefiltering);

    int updateCollaborativefiltering(Collaborativefiltering collaborativefiltering);

    int deleteCollaborativefilteringByIds(String ids);

    int deleteCollaborativefilteringById(Long id);

    int updateVisible(Collaborativefiltering collaborativefiltering);
}
