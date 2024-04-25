package com.example.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class Book {
    @Id
    private String id;

    private Genre genre;
    @NotNull
//    @Indexed(unique = true)
//    @Size(min = 5, max = 30)
    private String title;
//    @Trimmed
    private String author;
    private List<String> contributors ;
    private double price;

    public Book(String id, String title,String author,Genre genre,double price,List<String> contributors) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = (genre != null) ? genre : Genre.getDefault();
        this.contributors = contributors;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }
    public List<String> getContributors(){
        return contributors;
    }
}

