package com.space.common.enums;

public enum SerialNumEnum {

    //*****所有数字位均递增，位数不够用0补齐

    //资产意向
    ASSET_INTENTION("Z",4,true),

    // 角色编号
    ROLE_ID("RE", 9, false),
    // 用户编号
    USER_ID("UR", 9, false),
    // 公司、机构编号
    ORG_ID("OG", 9, false),
    // 菜单编号
    MENU_ID("MU", 9, false),


    ;

    SerialNumEnum(String serialPrefix, int digital, boolean isIncludeDate) {
        this.serialPrefix = serialPrefix;
        this.digital = digital;
        this.isIncludeDate=isIncludeDate;
    }
    private String serialPrefix;
    private int digital;
    private boolean isIncludeDate;

    public boolean isIncludeDate() {
        return isIncludeDate;
    }

    public void setIncludeDate(boolean includeDate) {
        isIncludeDate = includeDate;
    }

    public String getSerialPrefix() {
        return serialPrefix;
    }

    public void setSerialPrefix(String serialPrefix) {
        this.serialPrefix = serialPrefix;
    }

    public int getDigital() {
        return digital;
    }

    public void setDigital(int digital) {
        this.digital = digital;
    }





}
