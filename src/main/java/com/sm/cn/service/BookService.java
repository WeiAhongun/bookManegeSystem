package com.sm.cn.service;

import com.sm.cn.dto.SearchPageDTO;
import com.sm.cn.entity.Book;
import com.sm.cn.vo.PageResult;

import java.util.List;

public interface BookService {
    PageResult queryAll();

    PageResult searchPage(SearchPageDTO searchPageDTO);

    void addBook(Book book);

    Book query(int id);

    void updateBook(Book book);

    void delete(String str);
}
