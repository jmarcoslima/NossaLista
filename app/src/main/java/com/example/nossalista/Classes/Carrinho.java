package com.example.nossalista.Classes;

import android.content.ContentValues;

import com.example.nossalista.banco.Banco;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Comunicador{

    private long id;
    private long idUsuario;

    public Carrinho(long id, long idUsuario){

        this.id = id;
        this.idUsuario = idUsuario;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTabela() {

        return Banco.TABLE_CARRINHO;
    }

    @Override
    public ContentValues passarInfoParaInsert() {

        ContentValues cv = new ContentValues();

        cv.put(Banco.FK_USUARIO_C, idUsuario);

        return cv;
    }

    @Override
    public String getParamSelect() {
        return Banco.ID_CARRINHO;
    }

    @Override
    public String getColunaID() {
        return Banco.ID_CARRINHO;
    }

    @Override
    public List pegaTudo() {
        return null;
    }
}
