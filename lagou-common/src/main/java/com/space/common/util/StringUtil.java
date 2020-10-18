package com.space.common.util;

import cn.hutool.core.date.DateTime;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class StringUtil extends StringUtils {

    /**
     * 随机数需要的长度
     *
     * @param length
     */
    public static String getRadom(int length) {
        // 获取一个随机数
        double rand = Math.random();
        // 将随机数转换为字符串
        String str = String.valueOf(rand).replace("0.", "");
        // 截取字符串
        String newStr = str.substring(0, length);
        return newStr;
    }

    /**
     * 获取指定位数的随机字符串(包含小写字母、大写字母、数字,0<length)
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        // 随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    /**
     * 批次号
     *
     * @param length
     * @return
     */
    public static String getBatchId(int length) {
        return dateId() + getRandomString(length);
    }

    /**
     * 获取按照年月时分秒随机数生成的文件名
     *
     * @return
     */
    public static String getFileRandomName() {
        return DateTime.now().toString("yyyyMMddHHmmssSSS") + StringUtil.getRadom(4);
    }


    /**
     * 获取年月日时分秒字符串
     *
     * @return
     */
    public static String timestampId() {
        return DateTime.now().toString("yyyyMMddHHmmSS");
    }

    /**
     * 获取年月日字符串
     *
     * @return
     */
    public static String dateId() {
        return DateTime.now().toString("yyyyMMdd");
    }

    /**
     * 排除不需加签的成员变量
     *
     * @param name
     * @return
     */
    public static boolean rejectParam(String name) {
        String[] params = {"serialVersionUID", "sign", "requestNo", "requestId"};
        for (String param : params) {
            if (param.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 校验联系方式格式
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^((0\\d{2,3}-\\d{7,8})|(1[356784]\\d{9}))|(\\d{7,8})$");
            Matcher matcher = regex.matcher(mobileNumber);
            if (matcher.matches()) {
                flag = true;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 数字四舍五入保留两位小数
     *
     * @param num
     * @return
     */
    public static String roundDecimalNum(BigDecimal num) {
        return num.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static boolean phoneCheck(String phone) {
        final Pattern regex = compile("^[0-9|\\(|\\)|-]*$");
        Matcher matcher = regex.matcher(phone);
        if (matcher.matches() && phone.length() < 20) {
            return true;
        }
        return false;
    }

    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        if (str == null) {
            return null;
        } else {
            StringTokenizer st = new StringTokenizer(str, delimiters);
            ArrayList tokens = new ArrayList();

            while (true) {
                String token;
                do {
                    if (!st.hasMoreTokens()) {
                        return toStringArray((Collection) tokens);
                    }

                    token = st.nextToken();
                    if (trimTokens) {
                        token = token.trim();
                    }
                } while (ignoreEmptyTokens && token.length() <= 0);

                tokens.add(token);
            }
        }
    }


}
