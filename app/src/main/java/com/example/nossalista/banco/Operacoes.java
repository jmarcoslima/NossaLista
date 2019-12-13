package com.example.nossalista.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.Classes.Categoria;

public class Operacoes {

    Banco b;
    SQLiteDatabase db;

    public Operacoes(Context c){

        this.b = new Banco(c);

    }

    public void insert(String nome){

        db = b.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(b.COLUMN_NAME_CATEGORIA, nome);

        db.insert(b.TABLE_CATEGORIA, null, cv);
    }

    public Categoria select(String id){

        db = b.getReadableDatabase();

        String selection = b.COLUMN_ID_CATEGORIA + " = ?";
        String[] selectionArgs = {id};

        Cursor cursor = db.query(b.TABLE_CATEGORIA,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null);

        cursor.moveToNext();

        String nome = cursor.getString
                (cursor.getColumnIndex(b.COLUMN_NAME_CATEGORIA));

        long id2 = cursor.getLong(
                cursor.getColumnIndex(b.COLUMN_ID_CATEGORIA));

        return new Categoria(nome, id2);
    }

    public int delete(String id){

        SQLiteDatabase db = b.getWritableDatabase();

        String selection = b.COLUMN_ID_CATEGORIA + " LIKE ?";

        String[] selectionArgs = {id};

        return db.delete(b.TABLE_CATEGORIA, selection, selectionArgs);
    }

    public void update(String id){


    }


}
