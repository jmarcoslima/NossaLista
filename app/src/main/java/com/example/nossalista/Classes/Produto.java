package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.nossalista.banco.Banco;

import java.util.List;

public class Produto implements Comunicador{

    private long id;
    private String nome;
    private Categoria categoria;

    public Produto(){

    }

    public Produto(String nome, Categoria categoria){

        this.nome = nome;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getTabela() {

        return Banco.TABLE_PRODUTO;
    }

    @Override
    public ContentValues passarInfoParaInsert() {

        ContentValues cv = new ContentValues();

        cv.put(Banco.NOME_PRODUTO, getNome());
        cv.put(Banco.FK_CATEGORIA, getCategoria().getId());

        return cv;
    }

    @Override
    public String getParamSelect() {

        return Banco.ID_PRODUTO;
    }

    @Override
    public String getColunaID() {

        return Banco.ID_PRODUTO;
    }

    @Override
    public List pegaTudo() {
        return null;
    }

}
