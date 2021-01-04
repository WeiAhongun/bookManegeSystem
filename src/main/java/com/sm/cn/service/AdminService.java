package com.sm.cn.service;

import com.sm.cn.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> queryAll();

    Admin doLogin(Admin admin);
}
