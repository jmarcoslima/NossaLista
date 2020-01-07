package com.example.nossalista.teste;

import com.example.nossalista.Classes.Carrinho;
import com.example.nossalista.Classes.Categoria;
import com.example.nossalista.Classes.Item;
import com.example.nossalista.Classes.Produto;

import java.util.ArrayList;

public class CarrinhoTeste {

    private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();

    private static Carrinho c1, c2, c3;

    public CarrinhoTeste() {
    }

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

    }

    public static ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<Categoria> categorias) {
        CarrinhoTeste.categorias = categorias;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(ArrayList<Produto> produtos) {
        CarrinhoTeste.produtos = produtos;
    }

    public static Carrinho getC1() {
        return c1;
    }

    public static void setC1(Carrinho c1) {
        CarrinhoTeste.c1 = c1;
    }

    public static Carrinho getC2() {
        return c2;
    }

    public static void setC2(Carrinho c2) {
        CarrinhoTeste.c2 = c2;
    }

    public static Carrinho getC3() {
        return c3;
    }

    public static void setC3(Carrinho c3) {
        CarrinhoTeste.c3 = c3;
    }
}
