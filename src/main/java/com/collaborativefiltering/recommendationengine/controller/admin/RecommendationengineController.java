package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Recommendationengine;
import com.collaborativefiltering.recommendationengine.service.IRecommendationengineService;
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
 * 推荐引擎 Controller
 */
@Api(value = "推荐引擎" )
@Controller
@RequestMapping("/RecommendationengineController" )
public class RecommendationengineController extends BaseController {
    private String prefix = "admin/recommendationengine" ;
    @Autowired
    private IRecommendationengineService recommendationengineService;
    /**
     * 推荐引擎页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "推荐引擎分页跳转" )
    @GetMapping("/view" )
    //@RequiresPermissions("system:recommendationengine:view" )
    public String view(ModelMap model) {
        return prefix + "/list" ;
    }
    /**
     * list集合
     * @param tablepar 包含分页和搜索参数
     * @return ResultTable
     */
//    @Log(title = "推荐引擎", action = "list")
    @ApiOperation(value = "list", notes = "推荐引擎分页查询" )
    @GetMapping("/list" )
    //@RequiresPermissions("system:recommendationengine:list" )
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        // 设置分页参数
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        
        // 构建查询条件
        QueryWrapper<Recommendationengine> queryWrapper = new QueryWrapper<Recommendationengine>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("user_id", tablepar.getSearchText());
        }
        
        // 执行查询
        PageInfo<Recommendationengine> page = new PageInfo<Recommendationengine>(
                recommendationengineService.selectRecommendationengineList(queryWrapper));
        
        // 返回分页数据
        return pageTable(page.getList(), page.getTotal());
    }
    /**
     * 推荐引擎新增
     * @param recommendationengine
     * @return
     */
//    @Log(title = "推荐引擎新增", action = "add")
    @ApiOperation(value = "add", notes = "新增" )
    @PostMapping("/add" )
    //@RequiresPermissions("system:recommendationengine:add" )
    @ResponseBody
    public AjaxResult add(@RequestBody Recommendationengine recommendationengine) {
        return toAjax(recommendationengineService
                .insertRecommendationengine(recommendationengine));
    }
    /**
     * 推荐引擎删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除" )
    @DeleteMapping("/remove" )
    //@RequiresPermissions("system:recommendationengine:remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(recommendationengineService
                .deleteRecommendationengineByIds(ids));
    }
    /**
     * 修改推荐引擎跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改推荐引擎跳转" )
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id" ) Long id, ModelMap map) {
        map.put("Recommendationengine", recommendationengineService
                .selectRecommendationengineById(id));
        return prefix + "/edit" ;
    }
    /**
     * 推荐引擎修改保存
     * @param recommendationengine
     * @return
     */
//    @Log(title = "推荐引擎修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "推荐引擎修改保存" )
    //@RequiresPermissions("system:recommendationengine:edit" )
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave
    (@RequestBody Recommendationengine recommendationengine) {
        return toAjax(recommendationengineService
                .updateRecommendationengine
                        (recommendationengine));
    }
}
