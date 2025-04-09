package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IContentfilteringService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.ContentfilteringMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Contentfiltering;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 内容过滤Service业务层处理
 *
 */
@Service
public class ContentfilteringServiceImpl
        extends ServiceImpl<ContentfilteringMapper,
        Contentfiltering>
        implements IContentfilteringService {
    private static final Logger logger =
            LoggerFactory.getLogger(ContentfilteringServiceImpl.class);
    @Autowired
    private ContentfilteringMapper contentfilteringMapper;
    /**
     * 查询内容过滤
     *
     * @param id
     * @return Contentfiltering
     */
    @Override
    public Contentfiltering selectContentfilteringById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询内容过滤列表
     *
     * @param queryWrapper
     * @return Contentfiltering集合
     */
    @Override
    public List<Contentfiltering> selectContentfilteringList(Wrapper<Contentfiltering> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询内容过滤列表
     *
     * @param contentfiltering
     * @return Contentfiltering集合
     */
    @Override
    public List<Contentfiltering> selectContentfilteringList(Contentfiltering contentfiltering) {
        Map<String, Object> map =
                BeanUtil.beanToMap(contentfiltering, true, true);
        QueryWrapper<Contentfiltering> queryWrapper =
                new QueryWrapper<Contentfiltering>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增内容过滤
     *
     * @param contentfiltering
     * @return 结果
     */
    @Override
    public int insertContentfiltering(Contentfiltering contentfiltering) {
        if(StringUtils.isNotEmpty(contentfiltering.getContentfilteringName())){
            // 判断过滤名称是否为空
            throw new RuntimeException("内容过滤过滤名称不能为空！");
        }else if(contentfiltering.getContentfilteringName().length() > 255){
            throw new RuntimeException("内容过滤.过滤名称长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(contentfiltering.getFilterType())){
            // 判断过滤类型是否为空
            throw new RuntimeException("内容过滤过滤类型不能为空！");
        }else if(contentfiltering.getFilterType().length() > 255){
            throw new RuntimeException("内容过滤.过滤类型长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(contentfiltering.getFilterRule())){
            // 判断过滤规则是否为空
            throw new RuntimeException("内容过滤过滤规则不能为空！");
        }else if(contentfiltering.getFilterRule().length() > 255){
            throw new RuntimeException("内容过滤.过滤规则长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(contentfiltering.getCreatedAt())){
            // 判断创建时间是否为空
            throw new RuntimeException("内容过滤创建时间不能为空！");
        }else if(contentfiltering.getCreatedAt().length() > 255){
            throw new RuntimeException("内容过滤.创建时间长度不能超过255个字符");
        }
        if(contentfiltering.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("内容过滤更新时间不能为空！");
        }else if(isValidDate(contentfiltering.getUpdatedAt())){
            throw new RuntimeException("内容过滤更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.insert(contentfiltering);
    }
    /**
     * 修改内容过滤
     *
     * @param contentfiltering
     * @return 结果
     */
    @Override
    public int updateContentfiltering(Contentfiltering contentfiltering) {
        if(StringUtils.isNotEmpty(contentfiltering.getContentfilteringName())){
            // 判断过滤名称是否为空
            throw new RuntimeException("内容过滤过滤名称不能为空！");
        }else if(contentfiltering.getContentfilteringName().length() > 255){
            throw new RuntimeException("内容过滤.过滤名称长度不能超过255个字符");
        }
        if(StringUtils.isNotEmpty(contentfiltering.getFilterType())){
            // 判断过滤类型是否为空
            throw new RuntimeException("内容过滤过滤类型不能为空！");
        }else if(contentfiltering.getFilterType().length() > 255){
            throw new RuntimeException("内容过滤.过滤类型长度不能超过255个字符");
        }
        if(contentfiltering.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("内容过滤更新时间不能为空！");
        }else if(isValidDate(contentfiltering.getUpdatedAt())){
            throw new RuntimeException("内容过滤更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.updateById(contentfiltering);
    }
    /**
     * 批量删除内容过滤
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContentfilteringByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除内容过滤信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteContentfilteringById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new Exception("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改contentfiltering权限状态展示或者不展示
     *
     个性化隐私保护协同过滤推荐系统V1.0 16
     * @param contentfiltering
     * @return
     */
    @Override
    public int updateVisible(Contentfiltering contentfiltering) {
        return this.baseMapper.updateById(contentfiltering);
    }
}