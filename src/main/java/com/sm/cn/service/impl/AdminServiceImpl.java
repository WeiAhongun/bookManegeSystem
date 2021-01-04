package com.sm.cn.service.impl;

import com.sm.cn.entity.AdminExample;
import com.sm.cn.mapper.AdminMapper;
import com.sm.cn.entity.Admin;
import com.sm.cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    @Transactional
    public List<Admin> queryAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public Admin doLogin(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();

        String s = DigestUtils.md5DigestAsHex(password.getBytes());
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(s);

        List<Admin> admins = adminMapper.selectByExample(example);
        if(!admins.isEmpty()){
            return admins.get(0);
        }

        return null;
    }


}
