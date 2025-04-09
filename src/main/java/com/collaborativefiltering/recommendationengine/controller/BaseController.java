package com.collaborativefiltering.recommendationengine.controller;

import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import com.collaborativefiltering.recommendationengine.common.domain.ResultTable;

import java.util.List;

public class BaseController {
    public static ResultTable pageTable(List<?> list, long total) {
        ResultTable resultTable = new ResultTable();
        resultTable.setRows(list);    // 设置当前页数据
        resultTable.setTotal(total);  // 设置总记录数
        resultTable.setCode(0);       // 默认成功状态码
        resultTable.setMsg("查询成功");
        return resultTable;
    }

    public static AjaxResult toAjax(int rows) {
        // 如果影响的行数 > 0，返回成功；否则返回失败
        return rows > 0 ? AjaxResult.success() : AjaxResult.error("操作失败");
    }
}
