package com.example.nossalista.entidades;

import java.util.ArrayList;

public class Historico {

    private long id;
    private ArrayList<Carrinho> carrinhos;

    public Historico(){

    }

    public Historico(ArrayList<Carrinho> carrinhos){

        this.carrinhos = carrinhos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(ArrayList<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }
}
