package com.collaborativefiltering.recommendationengine.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Privacyaudit;
import com.collaborativefiltering.recommendationengine.service.IPrivacyauditService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;

/**
 * 隐私审计 Controller
 */
@Api(value = "隐私审计")
@Controller
@RequestMapping("/PrivacyauditController")
public class PrivacyauditController extends BaseController {
    private String prefix = "admin/privacyaudit";
    
    @Autowired
    private IPrivacyauditService privacyauditService;
    
    /**
     * 隐私审计页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "隐私审计分页跳转")
    @GetMapping("/view")
    //@RequiresPermissions("system:privacyaudit:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }
    
    /**
     * list集合
     * @param tablepar 包含分页和搜索参数
     * @return ResultTable
     */
    //@Log(title = "隐私审计", action = "list")
    @ApiOperation(value = "list", notes = "隐私审计分页查询")
    @GetMapping("/list")
    //@RequiresPermissions("system:privacyaudit:list")
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        // 设置分页参数
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        
        // 构建查询条件
        QueryWrapper<Privacyaudit> queryWrapper = new QueryWrapper<Privacyaudit>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("user_id", tablepar.getSearchText());
        }
        
        // 执行查询
        PageInfo<Privacyaudit> page = new PageInfo<Privacyaudit>(
                privacyauditService.selectPrivacyauditList(queryWrapper));
        
        // 返回分页数据
        return pageTable(page.getList(), page.getTotal());
    }
    
    /**
     * 隐私审计新增
     * @param privacyaudit
     * @return
     */
    //@Log(title = "隐私审计新增", action = "add")
    @ApiOperation(value = "add", notes = "新增")
    @PostMapping("/add")
    //@RequiresPermissions("system:privacyaudit:add")
    @ResponseBody
    public AjaxResult add(@RequestBody Privacyaudit privacyaudit) {
        return toAjax(privacyauditService.insertPrivacyaudit(privacyaudit));
    }
    
    /**
     * 隐私审计删除
     * @param ids
     * @return
     */
    //@Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    //@RequiresPermissions("system:privacyaudit:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(privacyauditService.deletePrivacyauditByIds(ids));
    }
    
    /**
     * 修改隐私审计跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改隐私审计跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap map) {
        map.put("Privacyaudit", privacyauditService.selectPrivacyauditById(id));
        return prefix + "/edit";
    }
    
    /**
     * 隐私审计修改保存
     * @param privacyaudit
     * @return
     */
    //@Log(title = "隐私审计修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "隐私审计修改保存")
    //@RequiresPermissions("system:privacyaudit:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Privacyaudit privacyaudit) {
        return toAjax(privacyauditService.updatePrivacyaudit(privacyaudit));
    }
}
