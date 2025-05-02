package com.yanshedui.backendcommon.handler;

import com.yanshedui.backendcommon.exception.BusinessException;
import com.yanshedui.backendcommon.results.Result;
import com.yanshedui.backendcommon.results.ResultCode;
import com.yanshedui.backendcommon.results.ResultMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.stream.Collectors;

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
        assert fieldError != null;
        return Result.error(ResultCode.ParamError, fieldError.getDefaultMessage());
    }

    /***
     * 当校验 路径变量 失败时触发
     * @param ex 查询参数校验失败时抛出的异常
     * @return 返回错误类型 ParamError
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> handleConstraintViolation(ConstraintViolationException ex) {
        String errorMsg = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        return Result.error(ResultCode.ParamError, errorMsg);
    }

    /***
     * 当校验 请求路径 不存在时触发
     * @param ex 请求路径不存在时抛出的异常
     * @return 返回错误类型 PathNotFound
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public Result<String> handleNoResourceFound(NoResourceFoundException ex) {
        return Result.error(ResultCode.PathNotFound, ResultMessage.PathNotFound + ex.getResourcePath());
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
        return Result.error(ResultCode.SystemError, ResultMessage.SystemError);
    }
}