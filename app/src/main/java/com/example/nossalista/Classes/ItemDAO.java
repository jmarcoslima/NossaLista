package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.banco.Conexao;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ItemDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirItem(Item i) {

        ContentValues values = new ContentValues();
        values.put("fkProduto", i.getFk());

        return banco.insert("item", null, values);
    }

    public void inserirItens(ArrayList<Item> itens){

        ContentValues values = new ContentValues();

        for (int i = 0; i < itens.size(); i++)
            inserirItem(itens.get(i));
    }

    public List<Item> meDAOsItens() {

        List<Item> itens = new ArrayList<>();

        Cursor cursor = banco.query("item", new String[]{"idItem", "fkProduto"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {

            Item i = new Item();
            i.setId(cursor.getInt(0));
            i.setFk(cursor.getInt(1));
            itens.add(i);
        }

        return itens;
    }

    public List<Produto> listar(List<Item> itens){

        String selection = "id" + " = ?";
        String[] selectionArgs = new String[1];
        Cursor cursor;

        List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < itens.size(); i++) {

            selectionArgs[0] = itens.get(i).getFk().toString();

            cursor = banco.query("produto", new String[]{"id", "nome","uri"},
                    selection, selectionArgs, null, null, null);

            cursor.moveToNext();

            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setUri(cursor.getString(2));
            produtos.add(p);
        }

        return produtos;
    }

}
