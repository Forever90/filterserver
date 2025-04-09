package com.collaborativefiltering.recommendationengine.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class ResultTable {
    private List<?> rows;   // 当前页的数据列表
    private long total;     // 总记录数（用于计算总页数）

    // 其他可能的字段（根据业务需求）：
    private int code;       // 状态码（如 0 表示成功）
    private String msg;     // 提示消息（如 "操作成功"）
}
