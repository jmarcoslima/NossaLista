package com.example.nossalista.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.Classes.Comunicador;

public class Operacoes {

    Banco b;
    SQLiteDatabase db;

    public Operacoes(Context c){

        this.b = new Banco(c);

    }

    public void insert(Comunicador c){

        db = b.getWritableDatabase();

        db.insert(c.getTabela(),
                null,
                c.passarInfoParaInsert());
    }

    public Cursor select(String s, Comunicador c){

        db = b.getReadableDatabase();

        String selection = c.getParamSelect() + " = ?";
        String[] selectionArgs = {s};

        Cursor cursor = db.query(c.getParamSelect(),
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        cursor.moveToNext();

        return cursor;
    }



    public int delete(Comunicador c){

        SQLiteDatabase db = b.getWritableDatabase();

        String selection = c.getColunaID() + " LIKE ?";

        String[] selectionArgs = {"id"};

        return db.delete(c.getTabela(), selection, selectionArgs);
    }

    public void update(String id, String nome){

        SQLiteDatabase db = b.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(b.NOME_PRODUTO, nome);

        String selection = b.ID_PRODUTO + " LIKE ?";
        String[] selectionArgs = {id};

        int linhasAfetadas = db.update(
                b.TABLE_PRODUTO,
                cv,
                selection,
                selectionArgs
        );
    }

}
