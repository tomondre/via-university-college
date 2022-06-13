package com.example.s09_networking.Ex01;

public class Product {
    private String name;
    private String price;
    private String rating;
    private String link;

    public Product(String name, String price, String rating, String link) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
