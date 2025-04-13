package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IPrivacysettingsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.PrivacysettingsMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacysettings;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 隐私设置Service业务层处理
 *
 */
@Service
public class PrivacysettingsServiceImpl
        extends ServiceImpl<PrivacysettingsMapper,
        Privacysettings>
        implements IPrivacysettingsService {
    private static final Logger logger =
            LoggerFactory.getLogger(PrivacysettingsServiceImpl.class);
    @Autowired
    private PrivacysettingsMapper privacysettingsMapper;
    /**
     * 查询隐私设置
     *
     * @param id
     * @return Privacysettings
     */
    @Override
    public Privacysettings selectPrivacysettingsById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询隐私设置列表
     *
     * @param queryWrapper
     * @return Privacysettings集合
     */
    @Override
    public List<Privacysettings> selectPrivacysettingsList(Wrapper<Privacysettings> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询隐私设置列表
     *
     个性化隐私保护协同过滤推荐系统V1.0 24
     * @param privacysettings
     * @return Privacysettings集合
     */
    @Override
    public List<Privacysettings> selectPrivacysettingsList(Privacysettings privacysettings) {
        Map<String, Object> map =
                BeanUtil.beanToMap(privacysettings, true, true);
        QueryWrapper<Privacysettings> queryWrapper =
                new QueryWrapper<Privacysettings>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增隐私设置
     *
     * @param privacysettings
     * @return 结果
     */
    @Override
    public int insertPrivacysettings(Privacysettings privacysettings) {
        if(StringUtils.isEmpty(privacysettings.getUserId())){
            // 判断用户id是否为空
            throw new RuntimeException("隐私设置用户id不能为空！");
        }else if(privacysettings.getUserId().length() > 255){
            throw new RuntimeException("隐私设置.用户id长度不能超过255个字符");
        }
        if(StringUtils.isEmpty(privacysettings.getProfileVisibility())){
            // 判断个人资料可见性是否为空
            throw new RuntimeException("隐私设置个人资料可见性不能为空！");
        }else if(privacysettings.getProfileVisibility().length() > 255){
            throw new RuntimeException("隐私设置.个人资料可见性长度不能超过255个字符");
        }
        if(privacysettings.getLastUpdated() == null){
            // 判断最后更新时间是否为空
            throw new RuntimeException("隐私设置最后更新时间不能为空！");
        }
//        else if(isValidDate(privacysettings.getLastUpdated())){
//            throw new RuntimeException("隐私设置最后更新时间日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.insert(privacysettings);
    }
    /**
     * 修改隐私设置
     *
     * @param privacysettings
     * @return 结果
     */
    @Override
    public int updatePrivacysettings(Privacysettings privacysettings) {
        if(StringUtils.isEmpty(privacysettings.getUserId())){
            // 判断用户id是否为空
            throw new RuntimeException("隐私设置用户id不能为空！");
        }else if(privacysettings.getUserId().length() > 255){
            throw new RuntimeException("隐私设置.用户id长度不能超过255个字符");
        }
        if(privacysettings.getLastUpdated() == null){
            // 判断最后更新时间是否为空
            throw new RuntimeException("隐私设置最后更新时间不能为空！");
        }
//        else if(isValidDate(privacysettings.getLastUpdated())){
//            throw new RuntimeException("隐私设置最后更新时间日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.updateById(privacysettings);
    }
    /**
     * 批量删除隐私设置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrivacysettingsByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除隐私设置信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deletePrivacysettingsById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改privacysettings权限状态展示或者不展示
     *
     * @param privacysettings
     * @return
     */
    @Override
    public int updateVisible(Privacysettings privacysettings) {
        return this.baseMapper.updateById(privacysettings);
    }
}