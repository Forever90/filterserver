package com.collaborativefiltering.recommendationengine.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    private int code;      // 状态码（例如：200=成功，500=失败）
    private String msg;    // 提示消息（如 "操作成功" 或 "更新失败"）
    private Object data;   // 附加数据（可选，此代码中可能未使用）

    // 静态工厂方法：快速创建成功/失败对象
    public static AjaxResult success() {
        return new AjaxResult(200, "操作成功", null);
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(500, msg, null);
    }

    // 链式调用支持（可选）
    public AjaxResult data(Object data) {
        this.data = data;
        return this;
    }
}
