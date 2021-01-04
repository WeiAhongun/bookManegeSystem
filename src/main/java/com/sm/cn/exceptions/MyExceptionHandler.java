package com.sm.cn.exceptions;

import com.sm.cn.vo.ResultJson;
import com.sm.cn.vo.ResultStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(LoginException.class)
    private ResultJson loginError(LoginException e){
        return ResultJson.erorr(e.getResultStatus());
    }

    @ExceptionHandler(Exception.class)
    private ResultJson globalException(Exception e){
        return ResultJson.erorr(ResultStatus.GLOBAL_ERROR);
    }
}
