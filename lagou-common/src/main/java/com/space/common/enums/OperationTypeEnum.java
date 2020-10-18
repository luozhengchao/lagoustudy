package com.space.common.enums;

public enum OperationTypeEnum {

    SELECT("0","查询"),
    INSERT("1","新增"),
    UPDATE("2","更新"),
    DELETE("3","删除"),
    ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String code;
    private String msg;

    OperationTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
