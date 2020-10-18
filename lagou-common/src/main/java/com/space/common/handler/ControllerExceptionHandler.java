package com.space.common.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.space.common.exception.ParamValidateException;
import com.space.common.exception.ServerException;
import com.space.common.model.entity.ApiResultEntity;
import com.space.common.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Iterator;

/**
 * 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResultEntity errorHandler(Exception ex) {
        logError(ResultCodeEnum.UNKNOW_ERROR.getCode(), ex);
        return ApiResultEntity.Builder.init()
                .error(ResultCodeEnum.UNKNOW_ERROR)
                .build();
    }

    @ExceptionHandler(value = ParamValidateException.class)
    public ApiResultEntity errorHandler(ParamValidateException ex) {
        logError(ResultCodeEnum.PARAMS_ERROR.getCode(), ex);
        String msg = ResultCodeEnum.PARAMS_ERROR.getMsg();
        msg = StringUtils.isEmpty(ex.getMessage()) ? msg : ex.getMessage();
        return ApiResultEntity.Builder.init()
                .withCode(ResultCodeEnum.PARAMS_ERROR.getCode())
                .withMsg(msg)
                .build();
    }

    @ExceptionHandler(value = ServerException.class)
    public ApiResultEntity errorHandler(ServerException ex) {
        logError(ex.getCode(), ex);
        return ApiResultEntity.Builder.init()
                .withCode(ex.getCode())
                .withMsg(ex.getMessage())
                .build();
    }


    /**
     * @param ex :
     * @Create xyj on 2018/10/24
     * @descrition: valid参数校验异常捕获处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResultEntity errorHandler(MethodArgumentNotValidException ex) {
        logError(ResultCodeEnum.PARAMS_ERROR.getCode(), ex);
        return ApiResultEntity.Builder.init()
                .withCode(ResultCodeEnum.PARAMS_ERROR.getCode())
                .withMsg(getErrorMessageFromMethodArgumentNotValidException(ex))
                .build();
    }

    private void logError(String errorCode, Exception ex) {
        log.info("ControllerExceptionHandler_logError_errorCode={}", errorCode);
        log.error("ControllerExceptionHandler_errorHandler_ex={}", ExceptionUtil.stacktraceToString(ex));
    }

    /**
     * @param e :
     * @Create xyj on 2018/10/24
     * @descrition: 处理参数异常messge
     */
    private String getErrorMessageFromMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Iterator<FieldError> iterator = e.getBindingResult().getFieldErrors().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            FieldError next = iterator.next();
            sb.append(next.getDefaultMessage());
            if (iterator.hasNext()) {
                sb.append("|");
            }
        }
        return sb.toString();
    }
}
