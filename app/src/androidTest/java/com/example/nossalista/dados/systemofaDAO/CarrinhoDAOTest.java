package com.example.nossalista.dados.systemofaDAO;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.nossalista.entidades.Carrinho;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarrinhoDAOTest {

    private CarrinhoDAO meDAOoDAO(){

        return new CarrinhoDAO(
                InstrumentationRegistry.getInstrumentation().getTargetContext());
    }

    @Test
    public void criarCarrinho() {

        CarrinhoDAO dao = meDAOoDAO();

        dao.criarCarrinho("Lista");

    }

    @Test
    public void meDAOsCarrinhos() {

        CarrinhoDAO pera = meDAOoDAO();
        pera.criarCarrinho("Lista");

        ArrayList<Carrinho> lista = new ArrayList<Carrinho>(pera.meDAOsCarrinhos());

        for(Carrinho c : lista)
            System.out.println(c.getNome());

    }

    @Test
    public void excluir() {

        CarrinhoDAO pera = meDAOoDAO();
        pera.criarCarrinho("Lista");

        ArrayList<Carrinho> lista = new ArrayList<Carrinho>(pera.meDAOsCarrinhos());

        for(Carrinho c : lista)
            System.out.println(c.getNome());

        pera.excluir(lista.get(0));

        for(Carrinho c : lista)
            System.out.println(c.getNome());

    }
}