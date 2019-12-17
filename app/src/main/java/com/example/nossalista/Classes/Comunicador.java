package com.example.nossalista.Classes;

import android.content.ContentValues;
import android.database.Cursor;

public interface Comunicador {

    public String getTabela();

    public ContentValues passarInfoParaInsert();

    public String getParamSelect();

    public String getColunaID();
}
