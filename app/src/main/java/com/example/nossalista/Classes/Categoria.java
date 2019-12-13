package com.example.nossalista.Classes;

public class Categoria {

    private long id;
    private String nome;

    public Categoria(String nome){

        this.nome = nome;
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
}