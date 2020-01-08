package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.banco.Conexao;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public long inserirProduto(Item i) {

        ContentValues values = new ContentValues();
        values.put("fkProduto", i.getFk());

        return banco.insert("item", null, values);
    }

    public List<Item> obterTodos() {

        List<Item> itens = new ArrayList<>();

        Cursor cursor = banco.query("item", new String[]{"id", "fkProduto"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {

            Item i = new Item();
            i.setId(cursor.getInt(0));
            i.setFk(cursor.getInt(1));
            itens.add(i);
        }

        return itens;
    }

    public void listar(){

        
    }
}
