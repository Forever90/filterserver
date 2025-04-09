package com.collaborativefiltering.recommendationengine.service.impl;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.collaborativefiltering.recommendationengine.service.IDataencryptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collaborativefiltering.recommendationengine.common.support.ConvertUtil;
import com.collaborativefiltering.recommendationengine.mapper.auto.DataencryptionMapper;
import com.collaborativefiltering.recommendationengine.model.auto.Dataencryption;
import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * 数据加密Service业务层处理
 *
 */
@Service
public class DataencryptionServiceImpl
        extends ServiceImpl<DataencryptionMapper,
        Dataencryption>
        implements IDataencryptionService {
    private static final Logger logger =
            LoggerFactory.getLogger(DataencryptionServiceImpl.class);
    @Autowired
    private DataencryptionMapper dataencryptionMapper;
    /**
     * 查询数据加密
     *
     * @param id
     * @return Dataencryption
     */
    @Override
    public Dataencryption selectDataencryptionById(Long id) {
        return this.baseMapper.selectById(id);
    }
    /**
     * 查询数据加密列表
     *
     * @param queryWrapper
     * @return Dataencryption集合
     */
    @Override
    public List<Dataencryption> selectDataencryptionList(Wrapper<Dataencryption> queryWrapper) {
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 查询数据加密列表
     *
     * @param dataencryption
     * @return Dataencryption集合
     */
    @Override
    public List<Dataencryption> selectDataencryptionList(Dataencryption dataencryption) {
        Map<String, Object> map =
                BeanUtil.beanToMap(dataencryption, true, true);
        QueryWrapper<Dataencryption> queryWrapper =
                new QueryWrapper<Dataencryption>();
        queryWrapper.allEq(map, false);
        return this.baseMapper.selectList(queryWrapper);
    }
    /**
     * 新增数据加密
     *
     * @param dataencryption
     * @return 结果
     */
    @Override
    public int insertDataencryption(Dataencryption dataencryption) {
        if(StringUtils.isNotEmpty(dataencryption.getDataencryptionName())){
            // 判断加密名称是否为空
            throw new RuntimeException("数据加密加密名称不能为空！");
        }else if(dataencryption.getDataencryptionName().length() > 255){
            throw new RuntimeException("数据加密.加密名称长度不能超过255个字符");
        }
        if(dataencryption.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("数据加密更新时间不能为空！");
        }else if(isValidDate(dataencryption.getUpdatedAt())){
            throw new RuntimeException("数据加密更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.insert(dataencryption);
    }
    /**
     * 修改数据加密
     *
     * @param dataencryption
     * @return 结果
     */
    @Override
    public int updateDataencryption(Dataencryption dataencryption) {
        if(StringUtils.isNotEmpty(dataencryption.getDataencryptionName())){
            // 判断加密名称是否为空
            throw new RuntimeException("数据加密加密名称不能为空！");
        }else if(dataencryption.getDataencryptionName().length() > 255){
            throw new RuntimeException("数据加密.加密名称长度不能超过255个字符");
        }
        if(dataencryption.getUpdatedAt() == null){
            // 判断更新时间是否为空
            throw new RuntimeException("数据加密更新时间不能为空！");
        }else if(isValidDate(dataencryption.getUpdatedAt())){
            throw new RuntimeException("数据加密更新时间日期格式错误，请输入正确的日期格式。");
        }
        return this.baseMapper.updateById(dataencryption);
    }
    /**
     * 批量删除数据加密
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDataencryptionByIds(String ids) {
        return this.baseMapper.deleteBatchIds
                (Arrays.asList(ConvertUtil.toStrArray(ids)));
    }
    /**
     * 删除数据加密信息
     *
     * @param id
     * @return 结果
     */
    @Override
    public int deleteDataencryptionById(Long id) {
        if(id ==null){
            throw new RuntimeException("删除id不能为空");
        }
//        if(isCheceid ==null){
//            throw new RuntimeException("删除id不能为空");
//        }
        return this.baseMapper.deleteById(id);
    }
    /**
     * 修改dataencryption权限状态展示或者不展示
     *
     * @param dataencryption
     * @return
     */
    @Override
    public int updateVisible(Dataencryption dataencryption) {
        return this.baseMapper.updateById(dataencryption);
    }
}