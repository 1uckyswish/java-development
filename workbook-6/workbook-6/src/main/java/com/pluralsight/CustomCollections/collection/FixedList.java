package com.pluralsight.CustomCollections.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T>{
    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.items = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return "FixedList{" +
                "items=" + items +
                ", maxSize=" + maxSize +
                '}';
    }

    public void add(T item){
        if (items.size() >= maxSize){
            System.out.println("Sorry, you have reached the maximum size and cannot add more items.");
        } else {
            items.add(item);
        }
    }

}
