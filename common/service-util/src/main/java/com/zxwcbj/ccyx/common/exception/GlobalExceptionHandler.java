package com.zxwcbj.ccyx.common.exception;

import com.zxwcbj.ccyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author a8480
 */
/**
 * 是 Spring MVC 框架中的一个关键组件，负责将请求映射到具体的方法并处理这些方法的执行
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理器.当你出现这个异常时调用下面的方法
     */
    @ExceptionHandler(Exception.class)

    /**
     * 返回json数据
     * */
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }

    /**
     * 自定义异常处理方法
     *
     * @param ccxException
     * @return
     */
    @ExceptionHandler(CcyxException.class)
    @ResponseBody
    private Result error(CcyxException ccxException) {
        return Result.fail(null);
    }
}
