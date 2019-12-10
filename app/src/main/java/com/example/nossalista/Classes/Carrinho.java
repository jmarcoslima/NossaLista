package com.example.nossalista.Classes;

import java.util.ArrayList;

public class Carrinho {

    private long id;
    private ArrayList<Item> items;

    public Carrinho(){

    }

    public Carrinho(ArrayList<Item> items){

        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
