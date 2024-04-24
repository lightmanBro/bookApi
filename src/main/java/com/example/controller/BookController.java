package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        // Check if the book title already exists in the database
        if (bookService.existsByTitle(book.getTitle())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Book with title '" + book.getTitle() + "' already exists");
        } else {
            // Add the book as a new book
            Book addedBook = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
        }
    }

    //
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book).getBody();
    }
//
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook).getBody();
    }
//
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteBook(@PathVariable String id) {
    bookService.deleteBook(id);
    return ResponseEntity.status(HttpStatus.OK)
            .body("Book with ID '" + id + "' has been deleted");
}
}
