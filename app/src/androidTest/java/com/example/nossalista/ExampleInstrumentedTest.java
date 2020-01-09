package com.example.nossalista;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.nossalista.Classes.Item;
import com.example.nossalista.Classes.ItemDAO;
import com.example.nossalista.Classes.Produto;
import com.example.nossalista.Classes.ProdutoDAO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.nossalista", appContext.getPackageName());
    }

    private Context pegaContext() {

        return InstrumentationRegistry.getInstrumentation().getTargetContext();
    }


    private List<Produto> mockProdutoDAO() {

        ArrayList<Produto> produtos = new ArrayList<Produto>();

        produtos.add(new Produto("Banana", "Fruta", "a"));
        produtos.add(new Produto("Batata", "Legume", "b"));
        produtos.add(new Produto("Name", "a", "c"));

        return produtos;
    }

    private List<Item> mockItemDAO(){

        ArrayList<Item> itens = new ArrayList<Item>();
        ProdutoDAO produtoDAO = new ProdutoDAO(pegaContext());

        ArrayList<Produto> produtos =
                new ArrayList<Produto>(produtoDAO.meDAOsProdutos());

        for(int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).getId() == itens.get(i).getFk()){

                itens.add(new Item(produtos.get(i)));
                break;
            }
        }

        return itens;
    }

    @Test
    public void testaInsertProduto() {

        ArrayList<Produto> produtos =
                new ArrayList<Produto>(mockProdutoDAO());

        ProdutoDAO produtoDAO = new ProdutoDAO(pegaContext());
        produtoDAO.insereProdutos(produtos);

        ArrayList<Produto> meDAOsProdutos =
                new ArrayList<Produto>(produtoDAO.meDAOsProdutos());

        int index = 2;

        Assert.assertEquals(produtos.get(index).getNome(),
                meDAOsProdutos.get(index).getNome());
    }

    @Test
    public void testaInsertItem(){

        ArrayList<Item> itens =
                new ArrayList<Item>(mockItemDAO());

        ItemDAO itemDAO = new ItemDAO(pegaContext());
        itemDAO.inserirItens(itens);

        ArrayList<Item> meDAOsItens =
                new ArrayList<Item>(itemDAO.meDAOsItens());

        int index = 1;

        Assert.assertEquals(itens.get(index).getFk(),
                meDAOsItens.get(index).getFk());
    }

    @Test
    public void testItens(){

        ArrayList<Item> itens =
                new ArrayList<Item>(mockItemDAO());

        for (int i = 0; i < itens.size(); i++)
            Log.i("FK do Produto", itens.get(i).toString());
    }
}
