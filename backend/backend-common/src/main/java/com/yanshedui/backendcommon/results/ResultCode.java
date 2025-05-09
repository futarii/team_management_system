package com.yanshedui.backendcommon.results;

public interface ResultCode {

    public static final Integer InsertSuccess = 20001;
    public static final Integer InsertError = 20000;
    public static final Integer DeleteSuccess = 20011;
    public static final Integer DeleteError = 20010;
    public static final Integer UpdateSuccess = 20021;
    public static final Integer UpdateError = 20020;
    public static final Integer SelectSuccess = 20031;
    public static final Integer ParamError = 40000;
    public static final Integer DataAlreadyExist = 40010;
    public static final Integer PathNotFound = 40020;
    public static final Integer SystemError = 50000;


}
