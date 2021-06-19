package com.example.multiscreenapp.items;

import android.util.ArrayMap;

import java.io.Serializable;

public class ShoppingCart implements Serializable {

    private ShoppingCart() {

    }
    public void addItem(Merchandise item, int count){
        Integer c = items.get(item) == null ? 0: items.get(item);
        items.put(item, c+count);
    }

    static public  ShoppingCart getShoppingCart(){
        return cart;
    }

    public void removeItem(Merchandise item){
        items.remove(item);
    }

    public void removeAt(int index){
        items.removeAt(index);
    }

    public int getNumItems(){
        return items.size();
    }

    public Merchandise getItemAt(int index){
        return items.keyAt(index);
    }

    public int getCountAt(int index){
        return items.valueAt(index);
    }

    private final ArrayMap<Merchandise, Integer> items = new ArrayMap<>();

    static private ShoppingCart cart = new ShoppingCart();
}
