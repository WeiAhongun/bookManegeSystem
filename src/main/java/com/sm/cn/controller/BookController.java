package com.sm.cn.controller;

import com.github.pagehelper.PageHelper;
import com.sm.cn.dto.SearchPageDTO;
import com.sm.cn.entity.Book;
import com.sm.cn.service.BookService;
import com.sm.cn.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("book/queryAll")
    public ResultJson queryAll(@RequestParam(defaultValue = "1") int currentPage,
                               @RequestParam(defaultValue = "5")int PageSize, SearchPageDTO searchPageDTO){
        System.out.println(searchPageDTO);
        PageHelper.startPage(currentPage,PageSize);
        return ResultJson.success(service.searchPage(searchPageDTO));
    }

    @GetMapping("book/query/{id}")
    public ResultJson query(@PathVariable int id){
        return ResultJson.success(service.query(id));
    }

    @GetMapping("book/delete")
    public ResultJson delete(String str){
        service.delete(str);
        return ResultJson.success();
    }

    @PostMapping("pages/book/addBook")
    public ResultJson addBook(Book book) {
        if(book.getBookId()!=null){
            service.updateBook(book);
        }else {
            service.addBook(book);
        }
        return ResultJson.success();
    }
}
