package com.example.nossalista.Classes;

import android.content.ContentValues;

import com.example.nossalista.banco.Banco;

public class Item implements Comunicador{

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

    @Override
    public String getTabela() {
        return Banco.TABLE_ITEM;
    }

    @Override
    public ContentValues passarInfoParaInsert() {

        ContentValues cv = new ContentValues();

        cv.put(Banco.QTD_ITEM, getQtd());
        cv.put(Banco.FK_PRODUTO, produto.getId());

        return cv;
    }

    @Override
    public String getParamSelect() {
        return Banco.FK_CARRINHO;
    }

    @Override
    public String getColunaID() {
        return Banco.ID_ITEM;
    }
}
