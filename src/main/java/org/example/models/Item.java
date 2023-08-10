package org.example.models;

public class Item {
    //represents the search results
    private String name;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
