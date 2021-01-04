package com.sm.cn.interceptors;

import com.sm.cn.exceptions.LoginException;
import com.sm.cn.vo.ResultStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if(admin == null){
            //return true;
            throw new LoginException(ResultStatus.LOGIN_ERROR);
        }

        return true;
    }
}
