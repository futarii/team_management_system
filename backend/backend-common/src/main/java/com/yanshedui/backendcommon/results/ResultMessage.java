package com.yanshedui.backendcommon.results;

public interface ResultMessage {

    public static final String CurrentPageValid = "当前页码必须大于等于1";
    public static final String PageSizeValid = "每页数量必须大于等于1";
    public static final String InsertSuccess = "新增成功";
    public static final String InsertError = "新增失败";
    public static final String DeleteSuccess = "删除成功";
    public static final String DeleteError = "删除失败";
    public static final String UpdateSuccess = "更新成功";
    public static final String UpdateError = "更新失败";
    public static final String DataAlreadyExist = "请勿重复添加数据";
    public static final String PathNotFound = "请求路径不存在:";
    public static final String SystemError = "系统繁忙，请稍后再试";

}
