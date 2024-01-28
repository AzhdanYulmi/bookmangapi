package com.dost.bookmanagementapi.dto;

import com.dost.bookmanagementapi.model.Book;

public class BookDTO {
    private int id;
    private String name;
    private String author;
    private double price;
    private String pictureUrl;


    public BookDTO() {
    }


    public BookDTO(int id, String name, String author, double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }



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


    public static BookDTO fromEntity(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getPictureUrl()
        );
    }

    public Book toEntity() {
        return new Book(
                this.id,
                this.name,
                this.author,
                this.price,
                this.pictureUrl
        );
    }
}

