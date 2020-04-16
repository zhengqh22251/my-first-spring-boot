package com.zqh.test.myfirstspringboot.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一业务异常处理类
 * @Author：zhengqh
 * @date 2020/4/14 20:13
 **/
@ControllerAdvice(basePackages = {"com.zqh.test.myfirstspringboot",})
public class GlobalDefaultExceptionHandler {
    //BusinessException
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest req, Exception e){
        ErrorInfo errorInfo =new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }

}
