package com.collaborativefiltering.recommendationengine.controller.admin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;
import com.collaborativefiltering.recommendationengine.controller.BaseController;
import com.collaborativefiltering.recommendationengine.model.custom.Tablepar;
import com.collaborativefiltering.recommendationengine.model.auto.Dataencryption;
import com.collaborativefiltering.recommendationengine.service.IDataencryptionService;
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
 * 数据加密 Controller
 */
@Api(value = "数据加密" )
@Controller
@RequestMapping("/DataencryptionController" )
public class DataencryptionController extends BaseController {
    private String prefix = "admin/dataencryption" ;
    @Autowired
    private IDataencryptionService dataencryptionService;
    /**
     * 数据加密页面展示
     * @param model
     * @return String
     */
    @ApiOperation(value = "view", notes = "数据加密分页跳转" )
    @GetMapping("/view" )
    //@RequiresPermissions("system:dataencryption:view" )
    public String view(ModelMap model) {
        return prefix + "/list" ;
    }
    /**
     * list集合
     * @param tablepar 包含分页和搜索参数
     * @return ResultTable
     */
//    @Log(title = "数据加密", action = "list")
    @ApiOperation(value = "list", notes = "数据加密分页查询" )
    @GetMapping("/list" )
    //@RequiresPermissions("system:dataencryption:list" )
    @ResponseBody
    public ResultTable list(Tablepar tablepar) {
        // 设置分页参数
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        
        // 构建查询条件
        QueryWrapper<Dataencryption> queryWrapper = new QueryWrapper<Dataencryption>();
        if (StrUtil.isNotEmpty(tablepar.getSearchText())) {
            queryWrapper.like("user_id", tablepar.getSearchText());
        }
        
        // 执行查询
        PageInfo<Dataencryption> page = new PageInfo<Dataencryption>(
                dataencryptionService.selectDataencryptionList(queryWrapper));
        
        // 返回分页数据
        return pageTable(page.getList(), page.getTotal());
    }
    /**
     * 数据加密新增
     * @param dataencryption
     * @return
     */
//    @Log(title = "数据加密新增", action = "add")
    @ApiOperation(value = "add", notes = "新增" )
    @PostMapping("/add" )
    //@RequiresPermissions("system:dataencryption:add" )
    @ResponseBody
    public AjaxResult add(@RequestBody Dataencryption dataencryption) {
        return toAjax(dataencryptionService
                .insertDataencryption(dataencryption));
    }
    /**
     * 数据加密删除
     * @param ids
     * @return
     */
//    @Log(title = "remove", action = "remove")
    @ApiOperation(value = "删除", notes = "删除" )
    @DeleteMapping("/remove" )
    //@RequiresPermissions("system:dataencryption:remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dataencryptionService
                .deleteDataencryptionByIds(ids));
    }
    /**
     * 修改数据加密跳转
     * @param id
     * @param map
     * @return
     */
    @ApiOperation(value = "edit", notes = "修改数据加密跳转" )
    @GetMapping("/edit/{id}" )
    public String edit(@PathVariable("id") Long id, ModelMap map) {
        map.put("Dataencryption", dataencryptionService
                .selectDataencryptionById(id));
        return prefix + "/edit" ;
    }
    /**
     * 数据加密修改保存
     * @param dataencryption
     * @return
     */
//    @Log(title = "数据加密修改", action = "edit")
    @ApiOperation(value = "editSave", notes = "数据加密修改保存" )
    //@RequiresPermissions("system:dataencryption:edit" )
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(@RequestBody Dataencryption dataencryption) {
        return toAjax(dataencryptionService
                .updateDataencryption
                        (dataencryption));
    }
}