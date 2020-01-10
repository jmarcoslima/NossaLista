package com.example.nossalista.dados.systemofaDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.dados.persistencia.Conexao;
import com.example.nossalista.entidades.Carrinho;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public CarrinhoDAO(Context context){

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    /**
     * Insert de valores na tabela carrinho.
     */
    public long criarCarrinho(String nome) {

        ContentValues values = new ContentValues();
        values.put("nome", nome);

        return banco.insert("carrinho", null, values);
    }

    public List<Carrinho> meDAOsCarrinhos(){

        List<Carrinho> carrinhos = new ArrayList<>();

        Cursor cursor = banco.query("carrinho", new String[]{"id", "nome"},
                null, null, null, null, null);


        while (cursor.moveToNext()) {

            Carrinho c = new Carrinho();
            c.setId(cursor.getInt (0));
            c.setNome(cursor.getString(1));
            carrinhos.add(c);
        }

        return carrinhos;
    }

    public void excluir (Carrinho c) {

        banco.delete("carrinho", "id = ?",
                new String[]{c.getId().toString()});

    }
}
