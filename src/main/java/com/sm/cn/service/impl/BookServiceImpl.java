package com.sm.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.sm.cn.dto.SearchPageDTO;
import com.sm.cn.entity.Book;
import com.sm.cn.entity.BookExample;
import com.sm.cn.entity.Booktype;
import com.sm.cn.mapper.BookMapper;
import com.sm.cn.mapper.BooktypeMapper;
import com.sm.cn.service.BookService;
import com.sm.cn.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BooktypeMapper bookTypeMapper;

    @Override
    public PageResult queryAll() {
        //PageHelper.startPage(1,1);
        List<Book> books = mapper.selectByExample(null);
        PageInfo info = new PageInfo(books);
        books.forEach(i ->{
            Booktype booktype = bookTypeMapper.selectByPrimaryKey(i.getFirstTypeId());
            i.setFirstTypeName(booktype.getTypeName());

            Booktype booktype2 = bookTypeMapper.selectByPrimaryKey(i.getSecondTypeId());
            i.setSecondTypeName(booktype2.getTypeName());
        });


        return new PageResult(books, (int) info.getTotal());
    }

    @Override
    public PageResult searchPage(SearchPageDTO searchPageDTO) {
        //查询条件
        BookExample bookExample = new BookExample();

        BookExample.Criteria criteria = bookExample.createCriteria();
        BookExample.Criteria criteria1 = bookExample.createCriteria();
        BookExample.Criteria criteria2 = bookExample.createCriteria();

        //一级目录+二级目录+书名查询
        if(searchPageDTO.getFirstTypeId()!=-1){
            criteria.andFirstTypeIdEqualTo(searchPageDTO.getFirstTypeId());
        }
        if(searchPageDTO.getSecondTypeId()!=-1){
            criteria.andSecondTypeIdEqualTo(searchPageDTO.getSecondTypeId());
        }
        if(!StringUtil.isEmpty(searchPageDTO.getSearch())){
            criteria.andBookNameLike("%"+searchPageDTO.getSearch()+"%");
        }

        //一级目录+二级目录+描述信息查询
        if(searchPageDTO.getFirstTypeId()!=-1){
            criteria1.andFirstTypeIdEqualTo(searchPageDTO.getFirstTypeId());
        }
        if(searchPageDTO.getSecondTypeId()!=-1){
            criteria1.andSecondTypeIdEqualTo(searchPageDTO.getSecondTypeId());
        }
        if(!StringUtil.isEmpty(searchPageDTO.getSearch())){
            criteria1.andDescriptionLike("%"+searchPageDTO.getSearch()+"%");
        }

        //一级目录+二级目录+作者信息查询
        if(searchPageDTO.getFirstTypeId()!=-1){
            criteria2.andFirstTypeIdEqualTo(searchPageDTO.getFirstTypeId());
        }
        if(searchPageDTO.getSecondTypeId()!=-1){
            criteria2.andSecondTypeIdEqualTo(searchPageDTO.getSecondTypeId());
        }
        if(!StringUtil.isEmpty(searchPageDTO.getSearch())){
            criteria2.andAuthorNameLike("%"+searchPageDTO.getSearch()+"%");
        }
        //查询条件拼接
        bookExample.or(criteria);
        bookExample.or(criteria1);
        bookExample.or(criteria2);

        //查询
        bookExample.setOrderByClause("book_id desc");

        List<Book> books = mapper.selectByExample(bookExample);

        books.forEach(i ->{
            Booktype booktype = bookTypeMapper.selectByPrimaryKey(i.getFirstTypeId());
            i.setFirstTypeName(booktype.getTypeName());

            Booktype booktype2 = bookTypeMapper.selectByPrimaryKey(i.getSecondTypeId());
            i.setSecondTypeName(booktype2.getTypeName());
        });

        PageInfo info = new PageInfo(books);
        return new PageResult(books, (int) info.getTotal());
    }

    @Override
    public void addBook(Book book) {
        mapper.insert(book);
    }

    @Override
    public Book query(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBook(Book book) {
        mapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void delete(String str) {
        String[] as = str.split("A");
        List<String> strings = Arrays.asList(as);
        List<Integer> list = new ArrayList<>();
        //将String数组转成Integer数组
        CollectionUtils.mergeArrayIntoCollection(as,list);
        //创造删除条件
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookIdIn(list);

        mapper.deleteByExample(bookExample);
    }
}
