package com.ling.jsb.dao;

import com.ling.jsb.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("INSERT INTO tb_book (bookName, press, author) VALUES (#{bookName}, #{press}, #{author})")
    void insertBook(Book book);

    @Delete("DELETE FROM tb_book WHERE id = #{id}")
    void deleteBookById(Integer id);

    @Update("UPDATE tb_book SET bookName = #{bookName}, press = #{press}, author = #{author} WHERE id = #{id}")
    void updateBook(Book book);

    @Select("select * from tb_book where id = #{id}")
    Book findBookById(Integer id);

    @Select("select * from tb_book")
    List<Book> getAllBooks();
}