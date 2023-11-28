package com.ling.jsb.dao;

import com.ling.jsb.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from tb_book where id = #{id}")
    Book findBookById(Integer id);

    @Select("select * from tb_book")
    List<Book> getAllBooks();
}