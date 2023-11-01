package com.zxwcbj.ccyx.common.exception;

import com.zxwcbj.ccyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 全局异常处理类
 *
 **/

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理器.当你出现这个异常时调用下面的方法
     * */
    @ExceptionHandler(Exception.class)
    /**
     * 返回json数据
     */
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
         return Result.fail(null);
    }

}
