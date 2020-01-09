package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.banco.Conexao;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirProduto(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("uri",produto.getUri());
        values.put("categoria",produto.getCategoria());
        return banco.insert("produto", null, values);

    }

    public void insereProdutos(List<Produto> produtos){

        for (int i = 0; i < produtos.size(); i++)
            inserirProduto(produtos.get(i));
    }

    public List<Produto> meDAOsProdutos(String categoria) {

        String selection = "categoria" + " = ?";
        String[] selectionArgs = {categoria};
        List<Produto> produtos = new ArrayList<>();

        Cursor cursor = banco.query("produto", new String[]{"id", "nome","uri","categoria"},
                selection, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setUri(cursor.getString(2));
            p.setCategoria(cursor.getString(3));
            produtos.add(p);
        }


        return produtos;
    }

    public List<Produto> meDAOsProdutos() {

        List<Produto> produtos = new ArrayList<>();

        Cursor cursor = banco.query("produto", new String[]{"id", "nome","uri","categoria"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setUri(cursor.getString(2));
            produtos.add(p);
        }

        return produtos;
    }


    public void excluir(Produto p) {
        banco.delete("produto", "id = ?", new String[]{p.getId().toString()});

    }
}
