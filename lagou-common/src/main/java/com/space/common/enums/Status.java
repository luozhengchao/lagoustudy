package com.space.common.enums;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUKUN393 on 2018-12-12
 * Description:是或否的枚举均可用这个保证 0-是 1-否即可
 */
public enum Status {

    VALID("是",0),

    INVALID("否",1);

    private String msg;
    private Integer value;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getStrValue() {
        return String.valueOf(value);
    }

    Status(String msg, Integer value) {
        this.msg = msg;
        this.value = value;
    }

    /**
     * 获取枚举列表
     * @return
     */
    public static List<Status> getStatusList(){
        List<Status> list = new ArrayList<>();
        Status[] statusArr = Status.values();
        for (int i = 0;i<statusArr.length;i++){
            list.add(statusArr[i]);
        }
        return list;
    }

    /**
     * 通过value值查询msg
     * @param value
     * @return
     */
    public static String getMsgByValue(Integer value){
        Status[] statusArr = Status.values();
        for (int i = 0;i<statusArr.length;i++){
            if(ObjectUtils.isEmpty(value)){
                return "";
            }
            if(value.equals(statusArr[i].value)){
                return statusArr[i].msg;
            }
        }
        return "";
    }

    /**
     * 通过信息获取值
     * @param msg
     * @return
     */
    public static Integer getValueByMsg(String msg){
        for (Status status : Status.values()){
            if(msg.equals(status.msg)){
                return status.value;
            }
        }
        return null;
    }


}
