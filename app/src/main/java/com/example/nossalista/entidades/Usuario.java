package com.example.nossalista.entidades;

public class Usuario {

    private String nome;
    private long id;

    public Usuario(String nome, long id){

        this.nome = nome;
        this.id = id;
    }

    public Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
