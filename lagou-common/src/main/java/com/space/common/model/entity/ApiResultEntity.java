package com.space.common.model.entity;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.space.common.enums.ResultCodeEnum;
import com.space.common.response.ResponseHolder;
import com.space.common.util.MDCUtil;
import com.space.common.util.SpringContextUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
  * 接口调用结果通用类
  * @Author LUOZHENGCHAO674
  * @Date 2020-1-17 11:50
  */
@Data
@Slf4j
@ApiModel(value = "接口调用结果通用类")
public class ApiResultEntity<T> {

    @ApiModelProperty(value = "调用链ID")
    private String traceId;
    @ApiModelProperty(value = "响应码")
    private String code;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public static final class Builder {
        private String code;
        private String msg;
        private Object data;

        private Builder() {
        }

        public static Builder init() {
            return new Builder();
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder successWithData(Object data) {
            this.code = ResultCodeEnum.SUCCESS.getCode();
            this.msg = ResultCodeEnum.SUCCESS.getMsg();
            this.data = data;
            return this;
        }

        public Builder success() {
            this.code = ResultCodeEnum.SUCCESS.getCode();
            this.msg = ResultCodeEnum.SUCCESS.getMsg();
            return this;
        }


        public Builder failed(){
            this.code = ResultCodeEnum.FAILED.getCode();
            this.msg = ResultCodeEnum.FAILED.getMsg();
            return this;
        }

        public Builder error(ResultCodeEnum resultCode){
            this.code = resultCode.getCode();
            this.msg = resultCode.getMsg();
            return this;
        }

        public Builder error(ResultCodeEnum resultCode, String msg) {
            this.code = resultCode.getCode();
            this.msg = msg;
            return this;
        }

        public Builder error(String resultCode, String msg) {
            this.code = resultCode;
            this.msg = msg;
            return this;
        }

        public Builder withMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder withData(Object data) {
            this.data = data;
            return this;
        }

        private String initThreadNumber() {
            return MDCUtil.get();
        }

        public ApiResultEntity build() {
            ApiResultEntity apiResultEntity = new ApiResultEntity();
            apiResultEntity.msg = this.msg;
            apiResultEntity.data = this.data;
            apiResultEntity.code = this.code;
            apiResultEntity.traceId = initThreadNumber();
            try {
                ResponseHolder responseHolder = SpringContextUtil.getBean(ResponseHolder.class);
                if(responseHolder != null) {
                    responseHolder.setApiResultEntity(apiResultEntity);
                }
            } catch (Exception e) {
                log.warn("Builder_build_e={}", ExceptionUtil.getSimpleMessage(e));
            }
            return apiResultEntity;
        }
    }
}
