package com.example.nossalista.Classes;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Integer id;
    private List<Item> itens;

    public Carrinho(Integer id){

        this.id = id;
        //this.itens = new List<Item>;
    }

    public Carrinho(Integer id, List<Item> itens){

        this.id = id;
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
