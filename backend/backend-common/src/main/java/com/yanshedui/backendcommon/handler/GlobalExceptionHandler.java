package com.yanshedui.backendcommon.handler;

import com.yanshedui.backendcommon.exception.BusinessException;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /***
     * 当使用 @Valid 校验 请求体（@RequestBody） 失败时触发
     * @param ex 控制器方法的参数验证未通过时抛出的异常
     * @return 返回错误类型 ParamError
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidationException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMsg = fieldError != null ? fieldError.getDefaultMessage() : "未知参数错误";
        return Result.error(ResultCode.ParamError, errorMsg);
    }

    /***
     * 当校验 非请求体参数 失败时触发
     * @param ex 查询参数校验失败或参数类型转换失败时抛出的异常
     * @return 返回错误类型 ParamError
     */
    @ExceptionHandler(BindException.class)
    public Result<String> handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMsg = fieldError != null ? fieldError.getDefaultMessage() : "参数类型转换错误";
        return Result.error(ResultCode.ParamError, errorMsg);
    }

    /***
     * 处理业务逻辑异常
     * @param ex 一般为唯一字段重复时抛出异常
     * @return 返回错误类型 自定义
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException ex) {
        return Result.error(ex.getCode(), ex.getMessage());
    }

    /***
     * 捕获所有未被前面处理器处理的异常
     * @param ex 未预期的运行时异常（如空指针、数据库连接失败） 或 第三方库抛出的未处理异常
     * @return 返回错误类型 SystemError
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception ex) {
        return Result.error(ResultCode.SystemError, "系统繁忙，请稍后再试");
    }
}