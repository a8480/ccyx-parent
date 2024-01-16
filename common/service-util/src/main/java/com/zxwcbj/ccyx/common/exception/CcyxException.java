package com.zxwcbj.ccyx.common.exception;

import com.zxwcbj.ccyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 统一异常处理
 * @author syoukan
 */
@Data
public class CcyxException extends RuntimeException {
    private Integer code;
    private String message;

    /**
     * 使用指定的详细信息消息构造一个新的运行时异常;
     *  @param code;
     * @param message;
     */
    public  CcyxException(Integer code,String message){
        /*
        * 之所以使用super(message)是因为父类中有一个message属性
        * 如果不使用super(message)来调用父类的message属性
        * 那么调用父类的message属性时,就会产生空指针异常
        * */
        super(message);
        this.code = code;
    }
    public CcyxException(ResultCodeEnum resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    @Override
    public String toString() {
        return "CcyxException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
