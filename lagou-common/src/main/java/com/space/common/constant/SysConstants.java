package com.space.common.constant;

/**
  * 全局通用常量类
  * @Author LUOZHENGCHAO
  * @Date 2020-1-17 11:32
  */
public interface SysConstants {

    /**
      * 通用时间类常量
      * @Author LUOZHENGCHAO
      * @Date 2019-6-12 11:27
      */
    interface Date{
        /** 1分钟 (单位:秒)*/
        int ONE_MINUTE = 60;
        /** 1小时 (单位:秒)*/
        int ONE_HOUR = 60 * ONE_MINUTE;
        /** 1天 (单位:秒)*/
        int ONE_DAY = 24 * ONE_HOUR;
        /** 1周 (单位:秒)*/
        int ONE_WEEK = 7 * ONE_DAY;
        /** 15分钟(单位:秒) */
        int MINUTE_15 = 15 * ONE_MINUTE;
    }

    /**
      * 通用符号类常量
      * @Author LUOZHENGCHAO
      * @Date 2019-6-12 11:27
      */
    interface Symbol{
        /** 换行符:\n */
        String LINE_BREAK = "\n";
        /** 下划线:_ */
        String CONNECT = "_";
        /** 逗号:,*/
        String SPLIT = ",";
        /** 冒号 : */
        String VALUE = ":";
        /** 空白符:" " */
        String BLANK = " ";
        /** 空串符号:"" */
        String NULL_STR = "";
        /** 加号:+ */
        String ADD = "+";
        /** 减号:- */
        String MINUS = "-";
        /** 等号:= */
        String EUQAL = "=";
        /** 是：字符串1 */
        String YES_1 = "1";
        /** 否：字符串0 */
        String NO_0 = "0";
        /** 百分号：字符串0 */
        String PERCENT = "%";
    }

    /**
     * 数字常量（String）
     */
    interface StrNumber{

        /** -1 */
        String MINUS_ONE = "-1";
        /** 0 */
        String ZERO = "0";
        /** 1 */
        String ONE = "1";
    }

    /**
     * 数字常量（Integer）
     */
    interface IntNumber{

        /** -1 */
        Integer MINUS_ONE = -1;
        /** 0 */
        Integer ZERO = 0;
        /** 1 */
        Integer ONE = 1;
    }
}
