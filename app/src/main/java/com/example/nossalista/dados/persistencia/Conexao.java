package com.example.nossalista.dados.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 2;
    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE produto" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(50)," +
                "uri VARCHAR(75)," +
                "categoria VARCHAR(50))");

        db.execSQL("CREATE TABLE item (" +
                "idItem INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fkProduto INTEGER," +
                "qtd INTEGER," +
                "FOREIGN KEY(fkProduto) REFERENCES produto)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }
}
