package com.sm.cn.service;

import com.sm.cn.entity.Booktype;

import java.util.List;

public interface BooktypeService {
    List<Booktype> quertAll();

    List<Booktype> getBooktypeByParentId(int parentId);
}
