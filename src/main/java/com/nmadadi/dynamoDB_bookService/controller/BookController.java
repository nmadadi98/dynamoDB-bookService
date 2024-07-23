package com.nmadadi.dynamoDB_bookService.controller;

import com.nmadadi.dynamoDB_bookService.service.BookService;
import com.nmadadi.dynamoDB_bookService.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") String id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/book/{id}")
    public String updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        return  bookService.delete(id);
    }


}
