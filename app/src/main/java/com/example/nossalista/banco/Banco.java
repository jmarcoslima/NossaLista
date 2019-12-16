package com.example.nossalista.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    public static final String DB_NAME = "Lista.db";
    public static final int DATABASE_VERSION = 1;

    public final String TABLE_PRODUTO = "Produto";
    public final String ID_PRODUTO = "id";
    public final String NOME_PRODUTO = "nome";
    public final String FK_USUARIO = "fk_usuario";
    public final String FK_CATEGORIA = "fk_categoria";
    public final String URI_FOTO_PRODUTO = "uri_foto";

    public final String TABLE_CATEGORIA = "Categoria";
    public final String NOME_CATEGORIA = "nome";
    public final String ID_CATEGORIA = "id";
    public final String URI_FOTO_CATEGORIA = "uri_foto";

    public final String TABLE_CARRINHO = "Carrinho";
    public final String ID_CARRINHO = "id";
    public final String FK_USUARIO_C = "fk_usuario";

    public final String TABLE_ITEM = "Item";
    public final String ID_ITEM = "id";
    public final String FK_CARRINHO = "fk_carrinho";
    public final String FK_PRODUTO = "fk_produto";
    public final String QTD_ITEM = "qtd";

    public final String TABLE_USUARIO = "Usuario";
    public final String ID_USUARIO = "id";

    public Banco(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String dll = "CREATE TABLE " + TABLE_CATEGORIA
                + " (" + ID_CATEGORIA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME_CATEGORIA + " VARCHAR(45) NOT NULL,"
                + URI_FOTO_CATEGORIA + " LONGTEXT"
                + ");";

        String dll2 = "CREATE TABLE " + TABLE_PRODUTO
                + " (" + ID_PRODUTO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  FK_CATEGORIA + " INTEGER,"
                +  FK_USUARIO + " INTEGER,"
                +  NOME_PRODUTO + " VARCHAR(45),"
                + " FOREIGN KEY(" + FK_CATEGORIA + ") REFERENCES Categoria(id),"
                + " FOREIGN KEY (" + FK_USUARIO + ") REFERENCES Usuario(id)"
                + ");";

        String dll3 = "CREATE TABLE " + TABLE_CARRINHO
                + "(" + ID_CARRINHO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  FK_USUARIO_C + " INTEGER, "
                +  "FOREIGN KEY (" + FK_USUARIO_C + ") REFERENCES Usuario(id)"
                + ");";

        String dll4 = "CREATE TABLE " + TABLE_ITEM
                + "(" + ID_ITEM + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  FK_PRODUTO + " INTEGER, "
                +  FK_CARRINHO + " INTEGER, "
                +  QTD_ITEM + " FLOAT, "
                + " FOREIGN KEY(" + FK_PRODUTO + ") REFERENCES Produto(id), "
                + " FOREIGN KEY(" + FK_CARRINHO + ") REFERENCES Carrinho(id)"
                + ");";

        String dll5 = "CREATE TABLE " + TABLE_USUARIO
                + "(" + ID_USUARIO + " INTEGER PRIMARY KEY"
                + ");";

        db.execSQL(dll);
        db.execSQL(dll2);
        db.execSQL(dll3);
        db.execSQL(dll4);
        db.execSQL(dll5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
