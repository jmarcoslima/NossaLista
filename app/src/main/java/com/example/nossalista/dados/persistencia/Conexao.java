package com.example.nossalista.dados.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe responsável por criar e atualizar as tabelas no banco.
 *
 * @author Diego <diego.santos@hbsis.com.br>
 */

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";

    /**
     * Versão do banco.
     * Quando for feita qualquer alteração no esquema
     * a versão dever ser incrementada.
     */
    private static final int version = 3;
    public Conexao(Context context) {
        super(context, name, null, version);
    }

    /**
     * Só roda uma vez. Alterações no esquema vão rodar
     * no onUpgrade.
     *
     * @param db
     */

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
                "fkCarrinho INTEGER, " +
                "qtd INTEGER," +
                "FOREIGN KEY(fkProduto) REFERENCES produto," +
                "FOREIGN KEY(fkCarrinho) REFERENCES carrinho)");

        db.execSQL("CREATE TABLE carrinho (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT)");
    }

    /**
     * Fazer as alterações do esquema aqui.
     *
     * @param db
     * @param oldVersion comparar com o atributo version, jogar num bloco if
     *                   e alterar o esquema.
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }
}
