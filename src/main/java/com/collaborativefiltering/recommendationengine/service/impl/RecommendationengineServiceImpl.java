package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IRecommendationengineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.RecommendationengineMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Recommendationengine;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 推荐引擎Service业务层处理
 *
 */
@Service
public class RecommendationengineServiceImpl extends ServiceImpl<RecommendationengineMapper, Recommendationengine> implements IRecommendationengineService {
    private static final Logger logger =
            LoggerFactory.getLogger(RecommendationengineServiceImpl.class);
    @Autowired
    private RecommendationengineMapper recommendationengineMapper;
    /**
     * 查询推荐引擎
     *
     * @param id
    个性化隐私保护协同过滤推荐系统V1.0 7
     * @return Recommendationengine
     */
    @Override
    public Recommendationengine selectRecommendationengineById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询推荐引擎列表
     *
     * @param queryWrapper
     * @return Recommendationengine集合
     */
    @Override
    public List<Recommendationengine> selectRecommendationengineList(Wrapper<Recommendationengine> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询推荐引擎列表
     *
     * @param recommendationengine
     * @return Recommendationengine集合
     */
    @Override
    public List<Recommendationengine> selectRecommendationengineList(Recommendationengine recommendationengine) {
        Map<String, Object> map =
                BeanUtil.beanToMap(recommendationengine, true, true);
        QueryWrapper<Recommendationengine> queryWrapper =
                new QueryWrapper<Recommendationengine>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增推荐引擎
     *
     * @param recommendationengine
     * @return 结果
     */
    @Override
    public int insertRecommendationengine(Recommendationengine recommendationengine) {
        if(StringUtils.isEmpty(recommendationengine.getRecommendationengineName())){
            // 判断推荐引擎名称是否为空
            throw new RuntimeException("推荐引擎推荐引擎名称不能为空！");
        }else if(recommendationengine.getRecommendationengineName().length() > 255){
            throw new RuntimeException("推荐引擎.推荐引擎名称长度不能超过255个字符");
        }
        if(StringUtils.isEmpty(recommendationengine.getAlgorithmType())){
            // 判断算法类型是否为空
            throw new RuntimeException("推荐引擎算法类型不能为空！");
        }else if(recommendationengine.getAlgorithmType().length() > 255){
            throw new RuntimeException("推荐引擎.算法类型长度不能超过255个字符");
        }
        if(recommendationengine.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("推荐引擎更新时间不能为空！");
        }
//        else if(isValidDate(recommendationengine.getUpdatedAt())){
//            throw new RuntimeException("推荐引擎更新时间日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.insert(recommendationengine);
    }
    /**
     * 修改推荐引擎
     *
     * @param recommendationengine
     * @return 结果
     */
    @Override
    public int updateRecommendationengine(Recommendationengine recommendationengine) {
        if(StringUtils.isEmpty(recommendationengine.getRecommendationengineName())){
            // 判断推荐引擎名称是否为空
            throw new RuntimeException("推荐引擎推荐引擎名称不能为空！");
        }else if(recommendationengine.getRecommendationengineName().length() > 255){
            throw new RuntimeException("推荐引擎.推荐引擎名称长度不能超过255个字符");
        }
        if(StringUtils.isEmpty(recommendationengine.getAlgorithmType())){
            // 判断算法类型是否为空
            throw new RuntimeException("推荐引擎算法类型不能为空！");
        }else if(recommendationengine.getAlgorithmType().length() > 255){
            throw new RuntimeException("推荐引擎.算法类型长度不能超过255个字符");
        }
        if(recommendationengine.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("推荐引擎更新时间不能为空！");
        }
//        else if(isValidDate(recommendationengine.getUpdatedAt())){
//            throw new RuntimeException("推荐引擎更新时间日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.updateById(recommendationengine);
    }
    /**
     * 批量删除推荐引擎
     *
     * @param ids 需要删除的数据ID
     * @return 结果
    个性化隐私保护协同过滤推荐系统V1.0 9
     */
    @Override
    public int deleteRecommendationengineByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除推荐引擎信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteRecommendationengineById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改recommendationengine权限状态展示或者不展示
     *
     * @param recommendationengine
     * @return
     */
    @Override
    public int updateVisible(Recommendationengine recommendationengine) {
        return this.baseMapper.updateById(recommendationengine);
    }
}
