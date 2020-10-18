package com.space.common.util;

/**
 * Redis key工具类
 *
 * @Author LUOZHENGCHAO674
 * @Date 2019-11-19 15:39
 */
public class RedisKeyUtil {

    enum prefixKey {

        /**登录token*/
        LOGIN_TOKEN("gateway:login:token"),

        /**流水号前缀*/
        SERIAL_PRIFIX("common:serial:number"),

        /**忘记密码用户信息校验key*/
        VERIFY_USER_INFO_ACESS_TOKEN_KEY("user:forgetPw:accessToken");




        /**redis前缀*/
        private String prefixKey;

        prefixKey(String key) {
            // user默认前缀:ocirf:tc
            StringBuffer prefixKeyBuf = new StringBuffer("ocirf:tc:").append(key);
            this.prefixKey = prefixKeyBuf.toString();
        }

        /**
         * 拼接key
         *
         * @param Strs
         * @return
         */
        public String appendAndGetKey(String... Strs) {
            StringBuffer prefixKeyBuf = new StringBuffer(prefixKey);
            for (String str : Strs) {
                prefixKeyBuf.append(":").append(str);
            }
            return prefixKeyBuf.toString();
        }
    }



    /**
     * 登录管理
     */
    public static class Login{
        public static String getTokenKey(String token){
            return prefixKey.LOGIN_TOKEN.appendAndGetKey(token);
        }
    }

    /**
     * 流水号前缀
     */
    public static class SerialNo{
        /**
         * 流水号前缀
         * @param serialPrefix
         * @param date
         * @return
         */
        public static String getSerialNumKey(String serialPrefix, String date) {
            return prefixKey.SERIAL_PRIFIX.appendAndGetKey(serialPrefix,date);
        }
    }

    /**
     * 忘记密码
     */
    public static class forgetPw {

        /**
         * 忘记密码accessTokenKey
         * value--用户信息
         *
         * @param accessToken
         * @return
         */
        public static String getAccessTokenKey(String accessToken) {
            return prefixKey.VERIFY_USER_INFO_ACESS_TOKEN_KEY.appendAndGetKey(accessToken);
        }

    }


}
