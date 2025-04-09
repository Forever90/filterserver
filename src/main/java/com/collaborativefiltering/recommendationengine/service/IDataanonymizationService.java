package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Dataanonymization;

import java.util.List;

public interface IDataanonymizationService {
    Dataanonymization selectDataanonymizationById(Long id);

    List<Dataanonymization> selectDataanonymizationList(Wrapper<Dataanonymization> queryWrapper);

    List<Dataanonymization> selectDataanonymizationList(Dataanonymization dataanonymization);

    int insertDataanonymization(Dataanonymization dataanonymization);

    int updateDataanonymization(Dataanonymization dataanonymization);

    int deleteDataanonymizationByIds(String ids);

    int deleteDataanonymizationById(Long id);

    int updateVisible(Dataanonymization dataanonymization);
}
