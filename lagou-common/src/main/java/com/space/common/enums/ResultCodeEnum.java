package com.space.common.enums;

import lombok.Getter;

/**
 * 系统全局异常返回码
 *
 * @Author LUOZHENGCHAO674
 * @Date 2020-1-17 13:40
 */
@Getter
public enum ResultCodeEnum {

    /**
     * 系统全局返回码
     * ************************************************************************************
     */
    SUCCESS("000000", "操作成功!"),
    UNKNOW_ERROR("999999", "未知服务错误"),
    FAILED("100000", "操作失败!"),
    PARAMS_ERROR("100001", "输入参数异常"),


    /**
     * user 22开头  22000001（11-user模块,00-登陆管理，0001-异常码）
     * *************************************************************************************
     */
    GENERATE_TOKEN_FAILED("11000001", "生成token失败"),
    PW_VALID_ERROR("11000002", "密码错误"),
    USER_VALID_ERROR("11000003", "当前登陆用户无效"),
    NAME_VALID_ERROR("11000004", "姓名错误"),
    PHONE_VALID_ERROR("11000005", "电话号码错误"),
    VALID_OVER_TIME("11000006", "用户信息校验超时"),
    PARENT_ORG_ID_ERROR("11000007","指定的上级机构不存在"),
    ORG_ID_EXISTED_ERROR("11000008","机构已经存在"),
    ORG_ID_NOT_EXISTED_ERROR("11000009","指定的机构不存在"),
    PARENT_ORG_ID_EQUALS_ERROR("11000010","指定机构的父机构与原有的不匹配"),
    ORG_NAME_EXISTED_ERROR("11000011","机构名称已经存在"),
    DELETE_ROLE_ERROR("11000012","公司管理员or超级管理员不能删除"),


    /** admin 33开头  33000001（33-admin模块,00-登陆管理，0001-异常码）
     * *************************************************************************************
     */



    IOBS_SUCCESS("88000001","上传IBOS成功"),
    IOBS_FAIL("88000002","上传IBOS失败"),
    IOBS_DOWN_FAIL("88000003","IBOS下載失败"),

    PUSHAUTHORIZEAPPLY_NOT_EXISTED_ERROR("90000000","委托授权书不存在"),

    ;

    private String code;
    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
