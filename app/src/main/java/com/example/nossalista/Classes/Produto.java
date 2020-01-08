package com.example.nossalista.Classes;

import android.content.ContentValues;

import java.util.List;

public class Produto{

    private Integer id;
    private String nome;
    private String categoria, uri;

    public Produto(){

    }

    public Produto(String nome, String categoria, String uri){

        this.nome = nome;
        this.categoria = categoria;
        this.uri = uri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
