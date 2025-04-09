package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Privacypolicies;
import com.collaborativefiltering.recommendationengine.service.IPrivacypoliciesService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 隐私政策 Controller
 */
@Api(value = "隐私政策" )
@Controller
@RequestMapping("/PrivacypoliciesController" )
public class PrivacypoliciesController extends BaseController {
    private String prefix = "admin/privacypolicies" ;
    @Autowired
    private IPrivacypoliciesService privacypoliciesService;
    /**
     * 隐私政策页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "隐私政策分页跳转" )
    @GetMapping("/view" )
    @RequiresPermissions("system:privacypolicies:view" )
    public String view(ModelMap model) {
        return prefix + "/list" ;
    }
    /**
     * list集合
     * @param tablepar
     * @return ResultTable
     */
//    @Log(title = "隐私政策", action = "list")
    @ApiOperation(value = "list", notes = "隐私政策分页跳转" )
    @GetMapping("/list" )
    @RequiresPermissions("system:privacypolicies:list" )
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        QueryWrapper<Privacypolicies> queryWrapper = new
                QueryWrapper<Privacypolicies>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("自定义", tablepar.getSearchText());
        }
        PageInfo<Privacypolicies> page =
                new PageInfo<Privacypolicies>
                        (privacypoliciesService
                                .selectPrivacypoliciesList(queryWrapper));
        return pageTable(page.getList(), page.getTotal());
    }
    /**
     * 隐私政策新增
     * @param privacypolicies
     * @return
     */
//    @Log(title = "隐私政策新增", action = "add")
    @ApiOperation(value = "add", notes = "新增" )
    @PostMapping("/add" )
    @RequiresPermissions("system:privacypolicies:add" )
    @ResponseBody
    public AjaxResult add(Privacypolicies privacypolicies) {
        return toAjax(privacypoliciesService
                .insertPrivacypolicies(privacypolicies));
    }
    /**
     * 隐私政策删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除" )
    @DeleteMapping("/remove" )
    @RequiresPermissions("system:privacypolicies:remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(privacypoliciesService
                .deletePrivacypoliciesByIds(ids));
    }
    /**
     * 修改隐私政策跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改隐私政策跳转" )
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap map) {
        map.put("Privacypolicies", privacypoliciesService
                .selectPrivacypoliciesById(id));
        return prefix + "/edit" ;
    }
    /**
     * 隐私政策修改保存
     * @param privacypolicies
     * @return
     */
//    @Log(title = "隐私政策修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "隐私政策修改保存" )
    @RequiresPermissions("system:privacypolicies:edit" )
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Privacypolicies privacypolicies) {
        return toAjax(privacypoliciesService
                .updatePrivacypolicies
                        (privacypolicies));
    }
}