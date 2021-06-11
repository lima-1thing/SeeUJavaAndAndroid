package com.example.shoppingcart1.items;

import android.util.ArrayMap;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
    public void addItem(Merchandize item, int count){
        Integer c = items.get(item) == null ? 0: items.get(item);
        items.put(item, c+count);
    }

    public void removeItem(Merchandize item){
        items.remove(item);
    }

    public void removeAt(int index){
        items.removeAt(index);
    }

    public int getNumItems(){
        return items.size();
    }

    public Merchandize getItemAt(int index){
        return items.keyAt(index);
    }

    public int getCountAt(int index){
        return items.valueAt(index);
    }

    private ArrayMap<Merchandize, Integer> items = new ArrayMap<>();
}
