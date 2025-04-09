package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Privacysettings;
import com.collaborativefiltering.recommendationengine.service.IPrivacysettingsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 隐私设置 Controller
 */
@Api(value = "隐私设置" )
@Controller
@RequestMapping("/PrivacysettingsController" )
public class PrivacysettingsController extends BaseController {
    private String prefix = "admin/privacysettings" ;
    @Autowired
    private IPrivacysettingsService privacysettingsService;
    /**
     * 隐私设置页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "隐私设置分页跳转" )
    @GetMapping("/view" )
    @RequiresPermissions("system:privacysettings:view" )
    public String view(ModelMap model) {
        return prefix + "/list" ;
    }
    /**
     * list集合
     * @param tablepar
     * @return ResultTable
     */
//    @Log(title = "隐私设置", action = "list")
    @ApiOperation(value = "list", notes = "隐私设置分页跳转" )
    @GetMapping("/list" )
    @RequiresPermissions("system:privacysettings:list" )
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        QueryWrapper<Privacysettings> queryWrapper = new
                QueryWrapper<Privacysettings>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("自定义", tablepar.getSearchText());
        }
        PageInfo<Privacysettings> page =
                new PageInfo<Privacysettings>
        (privacysettingsService
                .selectPrivacysettingsList(queryWrapper));
        return pageTable(page.getList(), page.getTotal());
    }
    /**
     * 隐私设置新增
     * @param privacysettings
     * @return
     */
//    @Log(title = "隐私设置新增", action = "add")
    @ApiOperation(value = "add", notes = "新增" )
    @PostMapping("/add" )
    @RequiresPermissions("system:privacysettings:add" )
    @ResponseBody
    public AjaxResult add(Privacysettings privacysettings) {
        return toAjax(privacysettingsService
                .insertPrivacysettings(privacysettings));
    }
    /**
     * 隐私设置删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除" )
    @DeleteMapping("/remove" )
    @RequiresPermissions("system:privacysettings:remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(privacysettingsService
                .deletePrivacysettingsByIds(ids));
    }
    /**
     * 修改隐私设置跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改隐私设置跳转" )
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap map) {
        map.put("Privacysettings", privacysettingsService
                .selectPrivacysettingsById(id));
        return prefix + "/edit" ;
    }
    /**
     * 隐私设置修改保存
     * @param privacysettings
     * @return
     */
//    @Log(title = "隐私设置修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "隐私设置修改保存" )
    @RequiresPermissions("system:privacysettings:edit" )
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave
            (Privacysettings privacysettings) {
        return toAjax(privacysettingsService
                .updatePrivacysettings
                        (privacysettings));
    }
}