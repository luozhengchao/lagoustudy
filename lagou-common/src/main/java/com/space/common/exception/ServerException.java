package com.space.common.exception;

import com.space.common.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class ServerException extends RuntimeException {

    private String code;

    public ServerException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServerException(ResultCodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }
}
