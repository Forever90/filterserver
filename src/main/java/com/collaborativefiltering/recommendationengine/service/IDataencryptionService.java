package com.collaborativefiltering.recommendationengine.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.collaborativefiltering.recommendationengine.model.auto.Dataencryption;

import java.util.List;

public interface IDataencryptionService {
    Dataencryption selectDataencryptionById(Long id);

    List<Dataencryption> selectDataencryptionList(Wrapper<Dataencryption> queryWrapper);

    List<Dataencryption> selectDataencryptionList(Dataencryption dataencryption);

    int insertDataencryption(Dataencryption dataencryption);

    int updateDataencryption(Dataencryption dataencryption);

    int deleteDataencryptionByIds(String ids);

    int deleteDataencryptionById(Long id);

    int updateVisible(Dataencryption dataencryption);
}
