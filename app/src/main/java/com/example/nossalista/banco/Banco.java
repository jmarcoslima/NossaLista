package com.example.nossalista.banco;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {

    public static final String DB_NAME = "Lista.db";
    public static final int DATABASE_VERSION = 1;

    public final String TABLE_PRODUTO = "Produto";
    public final String COLUMN_NAME_PRODUTO = "nome";

    public final String TABLE_CATEGORIA = "Categoria";
    public final String COLUMN_NAME_CATEGORIA = "nome";
    public final String COLUMN_ID_CATEGORIA = "id";

    public final String TABLE_CARRINHO = "Carrinho";
    public final String TABLE_ITEM = "Item";

    public Banco(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String dll = "CREATE TABLE " + TABLE_CATEGORIA
                + " (" + COLUMN_ID_CATEGORIA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  COLUMN_NAME_CATEGORIA + " VARCHAR(45) NOT NULL"
                + ");";

        String dll2 = "CREATE TABLE " + TABLE_PRODUTO
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " fkCategoria INTEGER,"
                + "nome VARCHAR(45),"
                + " FOREIGN KEY(id) REFERENCES Categoria(id)"
                + ");";

        String dll3 = "CREATE TABLE " + TABLE_CARRINHO
                + "( id INTEGER PRIMARY KEY AUTOINCREMENT "
                + ");";

        String dll4 = "CREATE TABLE " + TABLE_ITEM
                + "( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " fkProduto INTEGER, "
                + " fkCarrinho INTEGER, "
                + " qtd FLOAT, "
                + " FOREIGN KEY(fkProduto) REFERENCES Produto(id), "
                + " FOREIGN KEY(fkCarrinho) REFERENCES Carrinho(id)"
                + ");";

        db.execSQL(dll);
        db.execSQL(dll2);
        db.execSQL(dll3);
        db.execSQL(dll4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
