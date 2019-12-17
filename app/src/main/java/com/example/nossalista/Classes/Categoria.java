package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.nossalista.banco.Banco;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List pegaTudo() {

        List<Categoria> categorias = new ArrayList<Categoria>();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Clientes", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String sexo = cursor.getString(cursor.getColumnIndex("Sexo"));
            String uf = cursor.getString(cursor.getColumnIndex("UF"));
            boolean vip = cursor.getInt(cursor.getColumnIndex("Vip")) > 0;
            categorias.add(new Categoria(id, nome, sexo, uf, vip));
        }
        cursor.close();
        return clientes;
    }
}
