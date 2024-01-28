package com.dost.bookmanagementapi.dto;

import com.dost.bookmanagementapi.model.Book;

public class BookRequestDTO {
    private String name;
    private String author;
    private double price;
    private String pictureUrl;

    public BookRequestDTO() {
    }

    public BookRequestDTO(String name, String author, double price, String pictureUrl) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    // Convert to entity
    public Book toEntity() {
        return new Book(
                0, // Assuming ID is auto-generated and not set during creation
                this.name,
                this.author,
                this.price,
                this.pictureUrl
        );
    }
}

