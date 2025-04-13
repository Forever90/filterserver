package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IPrivacypoliciesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.PrivacypoliciesMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacypolicies;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 隐私政策Service业务层处理
 *
 */
@Service
public class PrivacypoliciesServiceImpl
        extends ServiceImpl<PrivacypoliciesMapper,
        Privacypolicies>
        implements IPrivacypoliciesService {
    private static final Logger logger =
            LoggerFactory.getLogger(PrivacypoliciesServiceImpl.class);
    @Autowired
    private PrivacypoliciesMapper privacypoliciesMapper;
    /**
     * 查询隐私政策
     *
     * @param id
     * @return Privacypolicies
     */
    @Override
    public Privacypolicies selectPrivacypoliciesById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询隐私政策列表
     *
     * @param queryWrapper
     * @return Privacypolicies集合
     */
    @Override
    public List<Privacypolicies> selectPrivacypoliciesList(Wrapper<Privacypolicies> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询隐私政策列表
     *
     * @param privacypolicies
     * @return Privacypolicies集合
     */
    @Override
    public List<Privacypolicies> selectPrivacypoliciesList(Privacypolicies privacypolicies) {
        Map<String, Object> map =
                BeanUtil.beanToMap(privacypolicies, true, true);
        QueryWrapper<Privacypolicies> queryWrapper =
                new QueryWrapper<Privacypolicies>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增隐私政策
     *
     * @param privacypolicies
     * @return 结果
     */
    @Override
    public int insertPrivacypolicies(Privacypolicies privacypolicies) {
        if(StringUtils.isEmpty(privacypolicies.getPolicyName())){
            // 判断政策名称是否为空
            throw new RuntimeException("隐私政策政策名称不能为空！");
        }else if(privacypolicies.getPolicyName().length() > 255){
            throw new RuntimeException("隐私政策.政策名称长度不能超过255个字符");
        }
        if(privacypolicies.getEffectiveDate() == null){
            // 判断生效日期是否为空
            throw new RuntimeException("隐私政策生效日期不能为空！");
        }
//        else if(isValidDate(privacypolicies.getEffectiveDate())){
//            throw new RuntimeException("隐私政策生效日期日期格式错误，请输入正确的日期格式。");
//        }
        if(privacypolicies.getLastUpdated() == null){
            // 判断最后更新时间是否为空
            throw new RuntimeException("隐私政策最后更新时间不能为空！");
        }
//        else if(isValidDate(privacypolicies.getLastUpdated())){
//            throw new RuntimeException("隐私政策最后更新时间日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.insert(privacypolicies);
    }
    /**
     * 修改隐私政策
     *
     * @param privacypolicies
     * @return 结果
     */
    @Override
    public int updatePrivacypolicies(Privacypolicies privacypolicies) {
        if(StringUtils.isEmpty(privacypolicies.getPolicyName())){
            // 判断政策名称是否为空
            throw new RuntimeException("隐私政策政策名称不能为空！");
        }else if(privacypolicies.getPolicyName().length() > 255){
            throw new RuntimeException("隐私政策.政策名称长度不能超过255个字符");
        }
        if(privacypolicies.getEffectiveDate() == null){
            // 判断生效日期是否为空
            throw new RuntimeException("隐私政策生效日期不能为空！");
        }
//        else if(isValidDate(privacypolicies.getEffectiveDate())){
//            throw new RuntimeException("隐私政策生效日期日期格式错误，请输入正确的日期格式。");
//        }
        return this.baseMapper.updateById(privacypolicies);
    }
    /**
     * 批量删除隐私政策
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrivacypoliciesByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除隐私政策信息
     *
     * @param id
    个性化隐私保护协同过滤推荐系统V1.0 31
     * @return 结果
     */
    @Override
    public int deletePrivacypoliciesById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改privacypolicies权限状态展示或者不展示
     *
     * @param privacypolicies
     * @return
     */
    @Override
    public int updateVisible(Privacypolicies privacypolicies) {
        return this.baseMapper.updateById(privacypolicies);
    }
}
