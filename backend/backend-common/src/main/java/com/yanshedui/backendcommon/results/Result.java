package com.yanshedui.backendcommon.results;

public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(Integer code, T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = code;
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.message = message;
        result.code = code;
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
