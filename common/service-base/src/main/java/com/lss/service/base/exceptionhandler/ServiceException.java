package com.lss.service.base.exceptionhandler;

import com.lss.utils.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {
    private Integer code;
    private String msg;

    public ServiceException(String message,Integer code){
        super(message);
        this.code = code;
    }
    public ServiceException(ResultCode resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
    @Override
    public String toString() {
        return "ServiceException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
