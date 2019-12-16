package com.example.nossalista.entidades;

public class Item {

    private Produto produto;
    private float qtd;

    public Item(Produto produto, float qtd){

        this.produto = produto;
        this.qtd = qtd;
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
}
