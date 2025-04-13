package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Dataanonymization;
import com.collaborativefiltering.recommendationengine.service.IDataanonymizationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 数据匿名 Controller
 */
@Api(value = "数据匿名")
@Controller
@RequestMapping("/DataanonymizationController")
public class DataanonymizationController extends BaseController {
    private String prefix = "admin/dataanonymization";
    
    @Autowired
    private IDataanonymizationService dataanonymizationService;
    
    /**
     * 数据匿名页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "数据匿名分页跳转")
    @GetMapping("/view")
    //@RequiresPermissions("system:dataanonymization:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }
    
    /**
     * list集合
     * @param tablepar 包含分页和搜索参数
     * @return ResultTable
     */
    //@Log(title = "数据匿名", action = "list")
    @ApiOperation(value = "list", notes = "数据匿名分页查询")
    @GetMapping("/list")
    //@RequiresPermissions("system:dataanonymization:list")
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        // 设置分页参数
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        
        // 构建查询条件
        QueryWrapper<Dataanonymization> queryWrapper = new QueryWrapper<Dataanonymization>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("user_id", tablepar.getSearchText());
        }
        
        // 执行查询
        PageInfo<Dataanonymization> page = new PageInfo<Dataanonymization>(
                dataanonymizationService.selectDataanonymizationList(queryWrapper));
        
        // 返回分页数据
        return pageTable(page.getList(), page.getTotal());
    }
    
    /**
     * 数据匿名新增
     * @param dataanonymization
     * @return
     */
    //@Log(title = "数据匿名新增", action = "add")
    @ApiOperation(value = "add", notes = "新增")
    @PostMapping("/add")
    //@RequiresPermissions("system:dataanonymization:add")
    @ResponseBody
    public AjaxResult add(@RequestBody Dataanonymization dataanonymization) {
        return toAjax(dataanonymizationService.insertDataanonymization(dataanonymization));
    }
    
    /**
     * 数据匿名删除
     * @param ids
     * @return
     */
    //@Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    //@RequiresPermissions("system:dataanonymization:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dataanonymizationService.deleteDataanonymizationByIds(ids));
    }
    
    /**
     * 修改数据匿名跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改数据匿名跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap map) {
        map.put("Dataanonymization", dataanonymizationService.selectDataanonymizationById(id));
        return prefix + "/edit";
    }
    
    /**
     * 数据匿名修改保存
     * @param dataanonymization
     * @return
     */
    //@Log(title = "数据匿名修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "数据匿名修改保存")
    //@RequiresPermissions("system:dataanonymization:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Dataanonymization dataanonymization) {
        return toAjax(dataanonymizationService.updateDataanonymization(dataanonymization));
    }
}
