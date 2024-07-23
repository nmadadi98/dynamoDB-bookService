package com.nmadadi.dynamoDB_bookService.service;

import com.nmadadi.dynamoDB_bookService.model.Book;
import com.nmadadi.dynamoDB_bookService.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(String id) {
        return bookRepository.getBookById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public String update(String id, Book book) {
        return bookRepository.update(id, book);
    }

    public String delete(String id) {
        return bookRepository.delete(id);
    }
}
