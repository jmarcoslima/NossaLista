package com.example.nossalista.Classes;

public class Produto {

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
}
