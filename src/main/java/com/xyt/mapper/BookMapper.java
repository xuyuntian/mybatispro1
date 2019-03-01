package com.xyt.mapper;

import com.xyt.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    List<Book> getBooks();
}
