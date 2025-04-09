package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IDataanonymizationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.DataanonymizationMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Dataanonymization;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 数据匿名Service业务层处理
 *
 */
@Service
public class DataanonymizationServiceImpl
        extends ServiceImpl<DataanonymizationMapper,
        Dataanonymization>
        implements IDataanonymizationService {
    private static final Logger logger =
            LoggerFactory.getLogger(DataanonymizationServiceImpl.class);
    @Autowired
    private DataanonymizationMapper dataanonymizationMapper;
    /**
     * 查询数据匿名
     *
     * @param id
     * @return Dataanonymization
     */
    @Override
    public Dataanonymization selectDataanonymizationById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询数据匿名列表
     *
     * @param queryWrapper
     * @return Dataanonymization集合
     */
    @Override
    public List<Dataanonymization> selectDataanonymizationList(Wrapper<Dataanonymization> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询数据匿名列表
     *
     * @param dataanonymization
     * @return Dataanonymization集合
     */
    @Override
    public List<Dataanonymization> selectDataanonymizationList(Dataanonymization dataanonymization) {
        Map<String, Object> map =
                BeanUtil.beanToMap(dataanonymization, true, true);
        QueryWrapper<Dataanonymization> queryWrapper =
                new QueryWrapper<Dataanonymization>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增数据匿名
     *
     * @param dataanonymization
    个性化隐私保护协同过滤推荐系统V1.0 36
     * @return 结果
     */
    @Override
    public int insertDataanonymization(Dataanonymization dataanonymization) {
        if(StringUtils.isNotEmpty(dataanonymization.getDataanonymizationName())){
            // 判断匿名名称是否为空
            throw new RuntimeException("数据匿名匿名名称不能为空！");
        }else if(dataanonymization.getDataanonymizationName().length() > 255){
            throw new RuntimeException("数据匿名.匿名名称长度不能超过255个字符");
        }
        if(dataanonymization.getAnonymizationDate() == null){
            // 判断匿名日期是否为空
            throw new RuntimeException("数据匿名匿名日期不能为空！");
        }else if(isValidDate(dataanonymization.getAnonymizationDate())){
            throw new RuntimeException("数据匿名匿名日期日期格式错误，请输入正确的日期格式。");
        }
        if(dataanonymization.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("数据匿名更新时间不能为空！");
        }else if(isValidDate(dataanonymization.getUpdatedAt())){
            throw new RuntimeException("数据匿名更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.insert(dataanonymization);
    }
    /**
     * 修改数据匿名
     *
     * @param dataanonymization
     * @return 结果
     */
    @Override
    public int updateDataanonymization(Dataanonymization dataanonymization) {
        if(StringUtils.isNotEmpty(dataanonymization.getDataanonymizationName())){
            // 判断匿名名称是否为空
            throw new RuntimeException("数据匿名匿名名称不能为空！");
        }else if(dataanonymization.getDataanonymizationName().length() > 255){
            throw new RuntimeException("数据匿名.匿名名称长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(dataanonymization.getUserId())){
            // 判断用户id是否为空
            throw new RuntimeException("数据匿名用户id不能为空！");
        }else if(dataanonymization.getUserId().length() > 255){
            throw new RuntimeException("数据匿名.用户id长度不能超过255个字符");
        }
        if(dataanonymization.getAnonymizationDate() == null){
            // 判断匿名日期是否为空
            throw new RuntimeException("数据匿名匿名日期不能为空！");
        }else if(isValidDate(dataanonymization.getAnonymizationDate())){
            throw new RuntimeException("数据匿名匿名日期日期格式错误，请输入正确的日期格式。");
        }
        if(dataanonymization.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("数据匿名更新时间不能为空！");
        }else if(isValidDate(dataanonymization.getUpdatedAt())){
            throw new RuntimeException("数据匿名更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.updateById(dataanonymization);
    }
    /**
     * 批量删除数据匿名
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDataanonymizationByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除数据匿名信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteDataanonymizationById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改dataanonymization权限状态展示或者不展示
     *
     * @param dataanonymization
     * @return
     */
    @Override
    public int updateVisible(Dataanonymization dataanonymization) {
        return this.baseMapper.updateById(dataanonymization);
    }
}