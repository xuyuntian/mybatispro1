package com.xyt.controller;

import com.xyt.mapper.BookMapper;
import com.xyt.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    BookMapper bookMapper;
    @RequestMapping("/books")
    public List<Book> books(){
        return bookMapper.getBooks();
    }
}