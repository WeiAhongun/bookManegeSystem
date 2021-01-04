package com.sm.cn.controller;

import com.sm.cn.entity.Admin;
import com.sm.cn.service.AdminService;
import com.sm.cn.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private AdminService service;

    @GetMapping("t1")
    public List<Admin> fun1(){
        return service.queryAll();
    }
}
