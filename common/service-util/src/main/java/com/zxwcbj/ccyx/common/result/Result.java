package com.zxwcbj.ccyx.common.result;

import lombok.Data;


/**
 * @author a8480
 */
@Data
public class Result<T> {
    /**状态码*/
    Integer code;
    /**消息*/
    String message;
    /**数据*/
    T data;

    /**构造私有化*/
    private Result() {
    }

    /**设置数据,返回对象的方法*/
    public static <T> Result<T> build( T data,ResultCodeEnum resultCodeEnum) {
        /*创建Resullt对象，设置值，返回对象*/
        Result<T> result=new Result<>();
        /*判断返回结果中是否需要数据*/
        if (data!=null){
            //设置数据到result对象
            result.setData(data);
        }
        //设置其他值
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return null;
    }
    /**成功的方法*/
    public  static <T> Result<T> ok(T data){
        return build(data,ResultCodeEnum.SUCCESS);
    }
    /**失败的方法*/
    public static <T> Result<T> fail(T data){
        return build(data,ResultCodeEnum.FAIL);
    }
}

