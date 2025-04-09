package com.collaborativefiltering.recommendationengine.service.impl;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.ICollaborativefilteringService;
import com.collaborativefiltering.recommendationengine.mapper.auto.CollaborativefilteringMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;

import com.collaborativefiltering.recommendationengine.model.auto.Collaborativefiltering;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 协同过滤Service业务层处理
 *
 */
@Service
public class CollaborativefilteringServiceImpl extends ServiceImpl<CollaborativefilteringMapper, Collaborativefiltering> implements ICollaborativefilteringService {
    private static final Logger logger =
            LoggerFactory.getLogger(CollaborativefilteringServiceImpl.class);
    @Autowired
    private CollaborativefilteringMapper collaborativefilteringMapper;
    /**
     * 查询协同过滤
     *
     * @param id
     * @return Collaborativefiltering
     */
    @Override
    public Collaborativefiltering selectCollaborativefilteringById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询协同过滤列表
     *
     * @param queryWrapper
     * @return Collaborativefiltering集合
     */
    @Override
    public List<Collaborativefiltering> selectCollaborativefilteringList(Wrapper<Collaborativefiltering> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询协同过滤列表
     *
     * @param collaborativefiltering
     * @return Collaborativefiltering集合
     */
    @Override
    public List<Collaborativefiltering> selectCollaborativefilteringList(Collaborativefiltering collaborativefiltering) {
        Map<String, Object> map =
                BeanUtil.beanToMap(collaborativefiltering, true, true);
        QueryWrapper<Collaborativefiltering> queryWrapper =
                new QueryWrapper<Collaborativefiltering>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增协同过滤
     *
     * @param collaborativefiltering
     * @return 结果
     */
    @Override
    public int insertCollaborativefiltering(Collaborativefiltering collaborativefiltering) {
        if(StringUtils.isNotEmpty(collaborativefiltering.getUserId())){
            // 判断用户id是否为空
            throw new RuntimeException("协同过滤用户id不能为空！");
        }else if(collaborativefiltering.getUserId().length() > 255){
            throw new RuntimeException("协同过滤.用户id长度不能超过255个字符");
        }
        if(collaborativefiltering.getTimestamp() == null){
            // 判断时间戳是否为空
            throw new RuntimeException("协同过滤时间戳不能为空！");
        }else if(isValidDate(collaborativefiltering.getTimestamp())){
            throw new RuntimeException("协同过滤时间戳日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.insert(collaborativefiltering);
    }
    /**
     * 修改协同过滤
     *
     * @param collaborativefiltering
     * @return 结果
    个性化隐私保护协同过滤推荐系统V1.0 3
     */
    @Override
    public int updateCollaborativefiltering(Collaborativefiltering collaborativefiltering) {
        if(StringUtils.isNotEmpty(collaborativefiltering.getUserId())){
            // 判断用户id是否为空
            throw new RuntimeException("协同过滤用户id不能为空！");
        }else if(collaborativefiltering.getUserId().length() > 255){
            throw new RuntimeException("协同过滤.用户id长度不能超过255个字符");
        }
        if(collaborativefiltering.getTimestamp() == null){
            // 判断时间戳是否为空
            throw new RuntimeException("协同过滤时间戳不能为空！");
        } else if(isValidDate(collaborativefiltering.getTimestamp())){
            throw new RuntimeException("协同过滤时间戳日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.updateById(collaborativefiltering);
    }
    /**
     * 批量删除协同过滤
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCollaborativefilteringByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除协同过滤信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteCollaborativefilteringById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改collaborativefiltering权限状态展示或者不展示
     *
     * @param collaborativefiltering
     * @return
    个性化隐私保护协同过滤推荐系统V1.0 4
     */
    @Override
    public int updateVisible(Collaborativefiltering collaborativefiltering) {
        return this.baseMapper.updateById(collaborativefiltering);
    }
}