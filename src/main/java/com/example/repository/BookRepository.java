package com.example.repository;

import com.example.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book,String> {
    boolean existsByTitle(String title);
}
