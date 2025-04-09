package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Collaborativefiltering;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.collaborativefiltering.recommendationengine.service.ICollaborativefilteringService;
/**
 * 协同过滤 Controller
 */
@Api(value = "协同过滤" )
@Controller
@RequestMapping("/CollaborativefilteringController" )
public class CollaborativefilteringController extends BaseController {
    private String prefix = "admin/collaborativefiltering" ;
    @Autowired
    private ICollaborativefilteringService collaborativefilteringService;
    /**
     * 协同过滤页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "协同过滤分页跳转" )
    @GetMapping("/view" )
    @RequiresPermissions("system:collaborativefiltering:view" )
    public String view(ModelMap model) {
        return prefix + "/list" ;
    }
    /**
     * list集合
     * @param tablepar
     * @return ResultTable
     */
//    @Log(title = "协同过滤", action = "list")
    @ApiOperation(value = "list", notes = "协同过滤分页跳转" )
    @GetMapping("/list" )
    @RequiresPermissions("system:collaborativefiltering:list" )
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        QueryWrapper<Collaborativefiltering> queryWrapper = new
                QueryWrapper<Collaborativefiltering>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("自定义", tablepar.getSearchText());
        }
        PageInfo<Collaborativefiltering> page =
                new PageInfo<Collaborativefiltering>
                        (collaborativefilteringService
                                .selectCollaborativefilteringList(queryWrapper));
        return pageTable(page.getList(), page.getTotal());
    }
    /**
     * 协同过滤新增
     * @param collaborativefiltering
     * @return
     */
//    @Log(title = "协同过滤新增", action = "add")
    @ApiOperation(value = "add", notes = "新增" )
    @PostMapping("/add" )
    @RequiresPermissions("system:collaborativefiltering:add" )
    @ResponseBody
    public AjaxResult add(Collaborativefiltering collaborativefiltering) {
        return toAjax(collaborativefilteringService
                .insertCollaborativefiltering(collaborativefiltering));
    }
    /**
     * 协同过滤删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除" )
    @DeleteMapping("/remove" )
    @RequiresPermissions("system:collaborativefiltering:remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(collaborativefilteringService
                .deleteCollaborativefilteringByIds(ids));
    }
    /**
     * 修改协同过滤跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改协同过滤跳转" )
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap map) {
        map.put("Collaborativefiltering", collaborativefilteringService
                .selectCollaborativefilteringById(id));
        return prefix + "/edit" ;
    }
    /**
     * 协同过滤修改保存
     个性化隐私保护协同过滤推荐系统V1.0 6
     * @param collaborativefiltering
     * @return
     */
//    @Log(title = "协同过滤修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "协同过滤修改保存" )
    @RequiresPermissions("system:collaborativefiltering:edit" )
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(Collaborativefiltering collaborativefiltering) {
        return toAjax(collaborativefilteringService
                .updateCollaborativefiltering
                        (collaborativefiltering));
    }
}