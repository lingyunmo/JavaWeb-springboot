package com.ling.jsb.controller;

import com.ling.jsb.pojo.Book;
import com.ling.jsb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myBook")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String findBookById(Integer id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "book";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam("bookName") String bookName,
                          @RequestParam("press") String press,
                          @RequestParam("author") String author,
                          Model model) {
        bookService.insertBook(new Book(null, bookName, press, author));
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/toUpdateBook")
    public String updateBook(@RequestParam Integer id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String UpdateBook(@RequestParam("bookId") Integer id,
                             @RequestParam("bookName") String bookName,
                             @RequestParam("press") String press,
                             @RequestParam("author") String author,
                             Model model) {
        bookService.updateBook(new Book(id, bookName, press, author));
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam Integer id, Model model) {
        bookService.deleteBookById(id);
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}