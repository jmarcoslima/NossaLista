package com.example.nossalista.entidades;

public class Carrinho {

    private String nome;
    private Integer id;

    public Carrinho( String nome, Integer id) {

        this.id = id;
        this.nome = nome;
    }
    public Carrinho (){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
