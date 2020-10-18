package com.space.common.enums;

/**
 * @title: 角色类型枚举
 * @className: RoleTypeEnum
 * @author: LUPEIFA851
 * @date: 2020-4-10 11:38
 */
public enum RoleTypeEnum {

    //角色类型（0-超级管理员，1-公司管理员，2-催收组长，3-催收组员）
    SUPER_ADMINISTRATOR("0", "超级管理员"),
    COMPANY_ADMINISTRATOR("1", "公司管理员"),
    COLLECTION_LEADER("2", "催收组长"),
    COLLECTION_MEMBER("3", "催收组员"),
    ;

    private String code;
    private String msg;


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

    RoleTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgByCode(String code) {
        RoleTypeEnum[] values = RoleTypeEnum.values();
        for (RoleTypeEnum roleTypeEnum : values) {
            if (roleTypeEnum.getCode().equals(code)) {
                return roleTypeEnum.getMsg();
            }
        }
        return null;
    }

    public static String getCodeByMsg(String msg) {
        RoleTypeEnum[] values = RoleTypeEnum.values();
        for (RoleTypeEnum roleTypeEnum : values) {
            if (roleTypeEnum.getMsg().equals(msg)) {
                return roleTypeEnum.getCode();
            }
        }
        return null;
    }


}
