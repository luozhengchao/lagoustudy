package com.space.common.enums;

/**
 * 数据权限枚举
 *
 * @Author LUOZHENGCHAO674
 * @Date 2020-3-24 9:35
 */
public enum PermissionTypeEnum {

    //

    PRIVATE("0", "私有权限"),
    GROUP("1", "集体权限");

    private String code;
    private String msg;

    PermissionTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
