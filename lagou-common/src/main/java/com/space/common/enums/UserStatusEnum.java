package com.space.common.enums;

/**
 * 用户状态枚举
 *
 * @Author LUOZHENGCHAO674
 * @Date 2020-3-24 9:35
 */
public enum UserStatusEnum {

    //用户状态：0-在职；1-休假；2-离职；

    ON_JOB("0", "在职"),
    ON_HOLIDAY("1", "休假"),
    DIMISSION("2", "离职");

    private String code;
    private String msg;

    UserStatusEnum(String code, String msg) {
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

    public static String getMsgByCode(String code) {
        UserStatusEnum[] values = UserStatusEnum.values();
        for (UserStatusEnum userStatusEnum : values) {
            if (userStatusEnum.getCode().equals(code)) {
                return userStatusEnum.getMsg();
            }
        }
        return null;
    }

    public static String getCodeByMsg(String msg) {
        UserStatusEnum[] values = UserStatusEnum.values();
        for (UserStatusEnum userStatusEnum : values) {
            if (userStatusEnum.getMsg().equals(msg)) {
                return userStatusEnum.getCode();
            }
        }
        return null;
    }
}
