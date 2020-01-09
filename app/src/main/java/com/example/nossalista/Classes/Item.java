package com.example.nossalista.Classes;

import android.content.ContentValues;

import java.util.List;

public class Item{

    private Integer id, fk;
    private Produto produto;
    private float qtd;

    public Item(Produto produto, float qtd, Integer id,
                Integer fk){

        this.produto = produto;
        this.qtd = qtd;
        this.id = id;
        this.fk = fk;
    }

    public Item(Produto produto){

        this.produto = produto;
        this.fk = produto.getId();
    }

    public Item(){

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFk() {
        return fk;
    }

    public void setFk(Integer fk) {
        this.fk = fk;
    }

    @Override
    public String toString(){

        return getProduto().toString();
    }
}
