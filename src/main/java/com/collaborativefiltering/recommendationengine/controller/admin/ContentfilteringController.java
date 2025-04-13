package com.collaborativefiltering.recommendationengine.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Contentfiltering;
import com.collaborativefiltering.recommendationengine.service.IContentfilteringService;
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
 * 内容过滤 Controller
 */
@Api(value = "内容过滤")
@Controller
@RequestMapping("/ContentfilteringController")
public class ContentfilteringController extends BaseController {
    private String prefix = "admin/contentfiltering";
    
    @Autowired
    private IContentfilteringService contentfilteringService;
    
    /**
     * 内容过滤页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "内容过滤分页跳转")
    @GetMapping("/view")
    //@RequiresPermissions("system:contentfiltering:view")
    public String view(ModelMap model) {
        return prefix + "/list";
    }
    
    /**
     * list集合
     * @param tablepar 包含分页和搜索参数
     * @return ResultTable
     */
//    @Log(title = "内容过滤", action = "list")
    @ApiOperation(value = "list", notes = "内容过滤分页查询")
    @GetMapping("/list")
    //@RequiresPermissions("system:contentfiltering:list")
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        // 设置分页参数
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        
        // 构建查询条件
        QueryWrapper<Contentfiltering> queryWrapper = new QueryWrapper<Contentfiltering>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("content_id", tablepar.getSearchText());
        }
        
        // 执行查询
        PageInfo<Contentfiltering> page = new PageInfo<Contentfiltering>(
                contentfilteringService.selectContentfilteringList(queryWrapper));
        
        // 返回分页数据
        return pageTable(page.getList(), page.getTotal());
    }
    
    /**
     * 内容过滤新增
     * @param contentfiltering
     * @return
     */
//    @Log(title = "内容过滤新增", action = "add")
    @ApiOperation(value = "add", notes = "新增")
    @PostMapping("/add")
    //@RequiresPermissions("system:contentfiltering:add")
    @ResponseBody
    public AjaxResult add(@RequestBody Contentfiltering contentfiltering) {
        return toAjax(contentfilteringService
                .insertContentfiltering(contentfiltering));
    }
    
    /**
     * 内容过滤删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除")
    @DeleteMapping("/remove")
    //@RequiresPermissions("system:contentfiltering:remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(contentfilteringService
                .deleteContentfilteringByIds(ids));
    }
    
    /**
     * 修改内容过滤跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改内容过滤跳转")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap map) {
        map.put("Contentfiltering", contentfilteringService
                .selectContentfilteringById(id));
        return prefix + "/edit";
    }
    
    /**
     * 内容过滤修改保存
     * @param contentfiltering
     * @return
     */
//    @Log(title = "内容过滤修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "内容过滤修改保存")
    //@RequiresPermissions("system:contentfiltering:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Contentfiltering contentfiltering) {
        return toAjax(contentfilteringService
                .updateContentfiltering(contentfiltering));
    }
}
