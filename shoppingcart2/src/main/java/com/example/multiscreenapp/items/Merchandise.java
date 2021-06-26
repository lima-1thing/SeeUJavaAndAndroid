package com.example.multiscreenapp.items;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Merchandise implements Serializable {
    private final String name;
    private final int imageId;
    private final double price;

    public Merchandise(String name, int imageId, double price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return String.format("%d|%s|%.2f", this.imageId, this.name, this.price)
                .hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if ( null == obj ) return false;
        Merchandise item = (Merchandise) obj;
        return this.name.equals(item.name)
                && this.imageId == item.imageId
                && Math.abs(this.price - item.price) < 0.0001;
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
