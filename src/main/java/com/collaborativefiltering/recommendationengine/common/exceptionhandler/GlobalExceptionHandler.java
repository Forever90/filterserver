package com.collaborativefiltering.recommendationengine.common.exceptionhandler;

import com.collaborativefiltering.recommendationengine.common.domain.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult handleRuntimeException(Exception ex) {
        return AjaxResult.error(ex.getMessage());
    }
}
