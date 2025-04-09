package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IPrivacyauditService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.PrivacyauditMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Privacyaudit;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 隐私审计Service业务层处理
 *
 */
@Service
public class PrivacyauditServiceImpl
        extends ServiceImpl<PrivacyauditMapper,
        Privacyaudit>
        implements IPrivacyauditService {
    private static final Logger logger =
            LoggerFactory.getLogger(PrivacyauditServiceImpl.class);
    @Autowired
    private PrivacyauditMapper privacyauditMapper;
    /**
     * 查询隐私审计
     *
     * @param id
     * @return Privacyaudit
     */
    @Override
    public Privacyaudit selectPrivacyauditById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询隐私审计列表
     *
     * @param queryWrapper
     * @return Privacyaudit集合
     */
    @Override
    public List<Privacyaudit> selectPrivacyauditList(Wrapper<Privacyaudit> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询隐私审计列表
     *
     * @param privacyaudit
     * @return Privacyaudit集合
     */
    @Override
    public List<Privacyaudit> selectPrivacyauditList(Privacyaudit privacyaudit) {
        Map<String, Object> map =
                BeanUtil.beanToMap(privacyaudit, true, true);
        QueryWrapper<Privacyaudit> queryWrapper =
                new QueryWrapper<Privacyaudit>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增隐私审计
     *
     * @param privacyaudit
     * @return 结果
     */
    @Override
    public int insertPrivacyaudit(Privacyaudit privacyaudit) {
        if(StringUtils.isNotEmpty(privacyaudit.getUserId())){
            // 判断用户id是否为空
            throw new Exception("隐私审计用户id不能为空！");
        }else if(privacyaudit.getUserId().length() > 255)){
            throw new Exception("隐私审计.用户id长度不能超过255个字符");
        }
        if(privacyaudit.getAuditDate() == null){
            // 判断审计日期是否为空
            throw new Exception("隐私审计审计日期不能为空！");
        }else if(isValidDate(privacyaudit.getAuditDate())){
            throw new Exception("隐私审计审计日期日期格式错误，请输入正确的日期格式。");
        }
        if(privacyaudit.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new Exception("隐私审计更新时间不能为空！");
        }else if(isValidDate(privacyaudit.getUpdatedAt())){
            throw new Exception("隐私审计更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.insert(privacyaudit);
    }
    /**
     * 修改隐私审计
     *
     * @param privacyaudit
     * @return 结果
     */
    @Override
    public int updatePrivacyaudit(Privacyaudit privacyaudit) {
        if(StringUtils.isNotEmpty(privacyaudit.getUserId())){
            // 判断用户id是否为空
            throw new Exception("隐私审计用户id不能为空！");
        }else if(privacyaudit.getUserId().length() > 255)){
            throw new Exception("隐私审计.用户id长度不能超过255个字符");
        }
        if(privacyaudit.getAuditDate() == null){
            // 判断审计日期是否为空
            throw new Exception("隐私审计审计日期不能为空！");
        }else if(isValidDate(privacyaudit.getAuditDate())){
            throw new Exception("隐私审计审计日期日期格式错误，请输入正确的日期格式。");
        }
        if(StringUtils.isNotEmpty(privacyaudit.getAuditType())){
            // 判断审计类型是否为空
            throw new Exception("隐私审计审计类型不能为空！");
        }else if(privacyaudit.getAuditType().length() > 255)){
            throw new Exception("隐私审计.审计类型长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(privacyaudit.getAuditResult())){
            // 判断审计结果是否为空
            throw new Exception("隐私审计审计结果不能为空！");
        }else if(privacyaudit.getAuditResult().length() > 255)){
            throw new Exception("隐私审计.审计结果长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(privacyaudit.getAuditStatus())){
            // 判断审计状态是否为空
            throw new Exception("隐私审计审计状态不能为空！");
        }else if(privacyaudit.getAuditStatus().length() > 255)){
            throw new Exception("隐私审计.审计状态长度不能超过255个字符");
        }
        if(privacyaudit.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new Exception("隐私审计更新时间不能为空！");
        }else if(isValidDate(privacyaudit.getUpdatedAt())){
            throw new Exception("隐私审计更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.updateById(privacyaudit);
    }
    /**
     * 批量删除隐私审计
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrivacyauditByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除隐私审计信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deletePrivacyauditById(Long id) {
        if(id ==null){
            throw new Exception("删除id不能为空");
        }
        if(isCheceid ==null){
            throw new Exception("删除id不能为空");
        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改privacyaudit权限状态展示或者不展示
     *
     * @param privacyaudit
     * @return
     */
    @Override
    public int updateVisible(Privacyaudit privacyaudit) {
        return this.baseMapper.updateById(privacyaudit);
    }
}