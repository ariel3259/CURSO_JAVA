package com.bootcamp.ApiBooks.Models;

public class Books {
    private Integer id;
    private String name;
    private String description;
    private String author;

    public Books(int id, String name, String description, String author){
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
