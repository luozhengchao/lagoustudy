package com.space.common.exception;

import com.space.common.enums.ResultCodeEnum;
import lombok.Data;

import javax.validation.ValidationException;


@Data
public class ParamValidateException extends ValidationException {

    private String code;

    public ParamValidateException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ParamValidateException(String message) {
        super(message);
    }

    public ParamValidateException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }
}
