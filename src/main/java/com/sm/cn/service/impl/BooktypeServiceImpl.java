package com.sm.cn.service.impl;

import com.sm.cn.entity.Booktype;
import com.sm.cn.entity.BooktypeExample;
import com.sm.cn.mapper.BooktypeMapper;
import com.sm.cn.service.BooktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooktypeServiceImpl implements BooktypeService {

    @Autowired
    private BooktypeMapper mapper;

    @Override
    public List<Booktype> quertAll() {
        BooktypeExample booktypeExample = new BooktypeExample();
        booktypeExample.setOrderByClause("type_id desc");

        return mapper.selectByExample(booktypeExample);
    }

    @Override
    public List<Booktype> getBooktypeByParentId(int parentId) {
        BooktypeExample booktypeExample = new BooktypeExample();
        BooktypeExample.Criteria criteria = booktypeExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return mapper.selectByExample(booktypeExample);
    }
}
