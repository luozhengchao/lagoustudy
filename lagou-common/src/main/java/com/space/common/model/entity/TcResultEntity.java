package com.space.common.model.entity;

import com.space.common.constant.SysConstants;
import com.space.common.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @title: 跟问鼎对接返回结果
 * @className: TcResultEntity
 * @author: LUPEIFA851
 * @date: 2020-4-7 14:40
 */
@Data
public class TcResultEntity<T> {

    @ApiModelProperty("版本")
    private String version;

    /**
     * 返回码
     * 000000成功
     */
    @ApiModelProperty("响应码")
    private String returnCode;

    /**
     * 返回信息
     */
    @ApiModelProperty("响应信息")
    private String returnMsg;

    /**
     * 返回数据
     */
    @ApiModelProperty("响应数据")
    private T returnData;

    /**
     * 判断是否保存、更新成功：201
     *
     * @return
     */
    public boolean isSaveSuccess() {
        return SysConstants.TcConstants.CODE_SUCCESS_SAVE.equals(returnCode);
    }

    /**
     * 判断是否查询成功：000000
     *
     * @return
     */
    public boolean isQueryveSuccess() {
        return SysConstants.TcConstants.CODE_SUCCESS_QUERY.equals(returnCode);
    }


    public static final class Builder {
        private String returnCode;
        private String returnMsg;
        private Object returnData;

        private Builder() {
        }

        public static TcResultEntity.Builder init() {
            return new TcResultEntity.Builder();
        }

        public TcResultEntity.Builder withCode(String returnCode) {
            this.returnCode = returnCode;
            return this;
        }

        public TcResultEntity.Builder successWithData(Object returnData) {
            this.returnCode = ResultCodeEnum.SUCCESS.getCode();
            this.returnMsg = ResultCodeEnum.SUCCESS.getMsg();
            this.returnData = returnData;
            return this;
        }

        public TcResultEntity.Builder success() {
            this.returnCode = ResultCodeEnum.SUCCESS.getCode();
            this.returnMsg = ResultCodeEnum.SUCCESS.getMsg();
            return this;
        }

        public TcResultEntity.Builder error(ResultCodeEnum resultCode) {
            this.returnCode = resultCode.getCode();
            this.returnMsg = resultCode.getMsg();
            return this;
        }

        public TcResultEntity.Builder withMsg(String returnMsg) {
            this.returnMsg = returnMsg;
            return this;
        }

        public TcResultEntity.Builder withData(Object returnData) {
            this.returnData = returnData;
            return this;
        }

        public TcResultEntity build() {
            TcResultEntity tcResultEntity = new TcResultEntity();
            tcResultEntity.returnMsg = this.returnMsg;
            tcResultEntity.returnData = this.returnData;
            tcResultEntity.returnCode = this.returnCode;
            return tcResultEntity;
        }
    }
}
