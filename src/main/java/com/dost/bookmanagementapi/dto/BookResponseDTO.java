package com.dost.bookmanagementapi.dto;

import com.dost.bookmanagementapi.model.Book;

public class BookResponseDTO {
    private int id;
    private String name;
    private String author;
    private double price;
    private String pictureUrl;

    public BookResponseDTO() {
    }

    public BookResponseDTO(int id, String name, String author, double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    // Convert from entity
    public static BookResponseDTO fromEntity(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getPictureUrl()
        );
    }
}
