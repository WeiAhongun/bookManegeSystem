package com.sm.cn.controller;

import com.sm.cn.entity.Admin;
import com.sm.cn.mapper.AdminMapper;
import com.sm.cn.service.AdminService;
import com.sm.cn.vo.ResultJson;
import com.sm.cn.vo.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private AdminService service;

    @PostMapping("common/login")
    public ResultJson login(Admin admin, HttpSession session) {
        Admin result = service.doLogin(admin);

        if(result == null){
            return ResultJson.success(ResultStatus.USERNAME_OR_PASSWOED_ERROR);
        }
        session.setAttribute("admin",result);
        return ResultJson.success();

    }
}
