package com.sm.cn.controller;

import com.sm.cn.exceptions.LoginException;
import com.sm.cn.service.BooktypeService;
import com.sm.cn.vo.ResultJson;
import com.sm.cn.vo.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booktype")
public class BooktypeController {
    @Autowired
    private BooktypeService service;

    @GetMapping("queryAll")
    public ResultJson quertAll(){
        return ResultJson.success(service.quertAll());
    }

    @GetMapping("error")
    public ResultJson quertAll1(){
        throw new LoginException(ResultStatus.LOGIN_ERROR);
    }

    @GetMapping("getBooktypeByParentId")
    public ResultJson getBooktypeByParentId(Integer id){
        return ResultJson.success(service.getBooktypeByParentId(id));
    }
}
