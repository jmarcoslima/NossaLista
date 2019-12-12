package com.example.nossalista.teste;

import com.example.nossalista.Classes.Carrinho;
import com.example.nossalista.Classes.Categoria;
import com.example.nossalista.Classes.Item;
import com.example.nossalista.Classes.Produto;

import java.util.ArrayList;

public class CarrinhoTeste {

    private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private static ArrayList<Carrinho> carrinhos = new ArrayList<Carrinho>();

    private static Carrinho c1, c2, c3;

    static {

        categorias.add(new Categoria("Vegetais"));
        categorias.add(new Categoria("Carne"));
        categorias.add(new Categoria("Refrigerante"));
        categorias.add(new Categoria("Laticíneos"));

        produtos.add(new Produto("Queijo", categorias.get(3)));
        produtos.add(new Produto("Leite", categorias.get(3)));
        produtos.add(new Produto("Coca-Cola", categorias.get(2)));
        produtos.add(new Produto("Alface", categorias.get(0)));
        produtos.add(new Produto("Bife", categorias.get(1)));

        ArrayList<Item> itens1 = new ArrayList<Item>();
        ArrayList<Item> itens2 = new ArrayList<Item>();
        ArrayList<Item> itens3 = new ArrayList<Item>();

        for (int i = 0; i < produtos.size(); i++){

            itens1.add(new Item(produtos.get(i), i));
            itens2.add(new Item(produtos.get(i), i));
            itens3.add(new Item(produtos.get(i), i));
        }

        c1 = new Carrinho(itens1);
        c2 = new Carrinho(itens2);
        c3 = new Carrinho(itens3);
    }
}
