package com.example.nossalista.Classes;

import android.content.ContentValues;

import com.example.nossalista.banco.Banco;

public class Categoria implements Comunicador{

    private long id;
    private String nome;

    public Categoria(String nome, long id){

        this.nome = nome;
        this.id = id;
    }

    public Categoria(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTabela() {

        return Banco.TABLE_CATEGORIA;
    }

    @Override
    public ContentValues passarInfoParaInsert() {

        ContentValues cv = new ContentValues();
        cv.put(Banco.NOME_CATEGORIA, getNome());

        return cv;
    }

    @Override
    public String getParamSelect() {

        return Banco.NOME_CATEGORIA;
    }

    @Override
    public String getColunaID() {

        return Banco.ID_CATEGORIA;
    }
}
