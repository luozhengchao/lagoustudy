package com.space.common.util;


import com.space.common.exception.ParamValidateException;
import com.space.common.exception.ServerException;
import com.space.common.enums.ResultCodeEnum;

public class PreconditionUtil {
    private PreconditionUtil() {
    }

    /**
     * 检查参数，不满足时抛出ParamValidateException
     *
     * @param expression
     * @param resultCodeEnum
     */
    public static void checkArgument(boolean expression, ResultCodeEnum resultCodeEnum) {
        if (!expression) {
            throw new ParamValidateException(resultCodeEnum);
        }
    }

    /**
     * 检查参数，不满足时抛出ParamValidateException
     *
     * @param expression
     * @param code
     * @param message
     */
    public static void checkArgument(boolean expression, String code, String message) {
        if (!expression) {
            throw new ParamValidateException(code, message);
        }
    }

    /**
     * 检查参数，不满足时抛出ParamValidateException
     *
     * @param expression
     * @param message
     */
    public static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new ParamValidateException(message);
        }
    }

    /**
     * 检查状态，不满足时抛出ServerException
     *
     * @param expression
     * @param resultCodeEnum
     */
    public static void checkState(boolean expression, ResultCodeEnum resultCodeEnum) {
        if (!expression) {
            throw new ServerException(resultCodeEnum);
        }
    }

    /**
     * 检查状态，不满足时抛出ServerException
     *
     * @param expression
     * @param code
     * @param message
     */
    public static void checkState(boolean expression, String code, String message) {
        if (!expression) {
            throw new ServerException(code, message);
        }
    }
}
