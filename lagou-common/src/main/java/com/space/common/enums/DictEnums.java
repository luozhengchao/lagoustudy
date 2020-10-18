package com.space.common.enums;


/**
  * 字典表枚举
  * @Author LUOZHENGCHAO674
  * @Date 2020-3-24 9:32
  */
public enum DictEnums {
    //

    EXECUTE_CLASSIFY("EXECUTE_CLASSIFY","数据过滤")
    ;

    private String key;
    private String keyDesc;

    public String getKey() {
        return key;
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    DictEnums(String key, String keyDesc) {
        this.key = key;
        this.keyDesc = keyDesc;
    }
}
