package com.example.nossalista.dados.systemofaDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nossalista.dados.persistencia.Conexao;
import com.example.nossalista.entidades.Item;
import com.example.nossalista.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por manipular as informações da tabela item
 *
 * @author Diego <diego.santos@hbsis.com.br>
 */

public class ItemDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ItemDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    /**
     *
     * @param i item para ser cadastrado
     * @return caso o produto do item já esteja na tabela o retorno é -1.
     *
     */
    public long inserirItem(Item i) {

        if (pegaFkProduto(i.getFkProduto()) > 0)
            return -1;

        ContentValues values = new ContentValues();
        values.put("fkProduto", i.getFkProduto());

        return banco.insert("item", null, values);
    }

    /**
     * Insere vários itens de uma vez. Fiz o método mais para testar o insert.
     *
     * @param itens
     */
    public void inserirItens(ArrayList<Item> itens){

        ContentValues values = new ContentValues();

        for (int i = 0; i < itens.size(); i++)
            inserirItem(itens.get(i));
    }

    /**
     * Busca os ids e fks da tabela item.
     *
     * @return List de Item gravados na tabela.
     */
    public List<Item> meDAOsItens() {

        List<Item> itens = new ArrayList<>();

        Cursor cursor = banco.query("item", new String[]{"idItem", "fkProduto"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {

            Item i = new Item();
            i.setId(cursor.getInt(0));
            i.setFkProduto(cursor.getInt(1));
            itens.add(i);
        }

        return itens;
    }

    /**
     *
     * @return pega as fks da tabela Item e busca todos os produtos
     *              que tenham id igual da tabela produto.
     */
    public List<Produto> listar(){

        String selection = "id" + " = ?";
        String[] selectionArgs = new String[1];
        Cursor cursor;

        List<Item> itens = meDAOsItens();
        List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < itens.size(); i++) {

            selectionArgs[0] = itens.get(i).getFkProduto().toString();

            cursor = banco.query("produto", new String[]{"id", "nome","uri"},
                    selection, selectionArgs, null, null, null);

            cursor.moveToNext();

            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setUri(cursor.getString(2));
            produtos.add(p);
        }

        return produtos;
    }

    /**
     * Exclui o item da tabela
     *
     * @param p pegar o id para comparar com a fk do item
     */
    public void excluir(Produto p){

        if (pegaFkProduto(p.getId()) > 0)
            banco.delete("item", "fkProduto = ?",
                new String[]{p.getId().toString()});
    }

    /**
     * Método para verificar se já existe um item cadastrado
     * com a fk igual ao idProduto.
     *
     * Serve para evitar repetições.
     *
     * @param idProduto
     *
     * @return -1 caso não se encontre um item com fk igual ao idProduto
     */
    public Integer pegaFkProduto(Integer idProduto){

        String selection = "fkProduto" + " = ?";
        String[] selectionArgs = {idProduto.toString()};

        Cursor cursor = banco.query("item", new String[]{"fkProduto"},
                selection, selectionArgs, null, null, null);

        if (cursor.moveToNext())
            return cursor.getInt(0);

        return -1;
    }
}
