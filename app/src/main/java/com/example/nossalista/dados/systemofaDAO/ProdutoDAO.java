package com.example.nossalista.dados.systemofaDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.dados.persistencia.Conexao;
import com.example.nossalista.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private Context context;

    public ProdutoDAO(Context context) {

        this.context = context;

        conexao = new Conexao(this.context);
        banco = conexao.getWritableDatabase();
    }

    public void atualizarProduto(Produto produto) {
        int id = produto.getId();
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("uri",produto.getUri());
        values.put("categoria",produto.getCategoria());
        banco.update("produto", values, "id = ?",new
                String[]{produto.getId().toString()});
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

    /**
     * Exclui o produto da tabela produto e verifica
     * se a id dele foi passada como fk para um item da tabela item,
     * caso sim, o ItemDAO é chamado para remover o item.
     *
     * @author Diego <diego.santos@hbsis.com.br>
     *
     * @param p produto que vai ser excluido
     */
    public void excluir(Produto p) {

        ItemDAO itemDAO = new ItemDAO(this.context);

        if (itemDAO.pegaFkProduto(p.getId()) > 0)
            itemDAO.excluir(p);

        banco.delete("produto", "id = ?",
                new String[]{p.getId().toString()});

    }
}
