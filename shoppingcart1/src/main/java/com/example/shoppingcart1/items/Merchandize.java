package com.example.shoppingcart1.items;

public class Merchandize {
    private String name;
    private int imageId;
    private double price;

    public Merchandize(String name, int imageId, double price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public double getPrice() {
        return price;
    }

}
