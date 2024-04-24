package com.example.service;

import com.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    void deleteBook(String id);

    Book getBookById(String id);
    Book updateBook(String id, Book book);

    boolean existsByTitle(String title);
}
