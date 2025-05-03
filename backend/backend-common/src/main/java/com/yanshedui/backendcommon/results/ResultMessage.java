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
    public static final String SystemError = "系统错误，请联系管理员";

    public static final String TitleNotFilled = "未填写标题";
    public static final String ContentNotFilled = "未填写标题";
    public static final String PositionNameEmpty = "角色名称不能为空";
    public static final String PositionCodeEmpty = "角色代码不能为空";
    public static final String PositionCodeLowercaseLetters = "角色代码必须为小写字母";
    public static final String RealNameEmpty = "真实姓名不能为空";
    public static final String JerseyNumberBeNegative = "球衣号必须为正数或0";
    public static final String PositionSelectionIncorrect = "球场位置必须是 forward、guard 或 center 之一";
    public static final String HeightFormatIncorrect = "身高格式不正确";
    public static final String WeightFormatIncorrect = "体重格式不正确";
    public static final String JoinDateEmpty = "入队日期不能为空";
    public static final String MatchNameEmpty = "比赛名称不能为空";
    public static final String MatchTimeEmpty = "比赛时间不能为空";
    public static final String MatchLocationEmpty = "比赛地点不能为空";
    public static final String OpponentEmpty = "对手球队不能为空";




}
