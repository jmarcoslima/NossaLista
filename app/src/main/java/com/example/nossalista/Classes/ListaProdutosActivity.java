package com.example.nossalista.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;

import com.example.nossalista.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ProdutoDAO dao;
    private List<Produto> produtos;
    private List<Produto> produtosFiltrados = new ArrayList<>();
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        rv = findViewById(R.id.rv);
        categoria = getIntent().getStringExtra("categoria");

        dao = new ProdutoDAO(this);

        produtos = dao.meDAOsProdutos(categoria);
        produtosFiltrados.addAll(produtos);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(new ListaAdapter(produtosFiltrados));

        registerForContextMenu(rv);
    }

    //Pesquisa de produtos

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraProduto(s);
                return false;
            }
        });

        return true;
    }

    public void procuraProduto(String nome) {
        produtosFiltrados.clear();
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                produtosFiltrados.add(p);
            }
        }
        rv.setAdapter(new ListaAdapter(produtosFiltrados));
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.menu_contexto, menu);

    }


    public void onResume() {
        super.onResume();
        produtos = dao.meDAOsProdutos(categoria);
        produtosFiltrados.clear();
        produtosFiltrados.addAll(produtos);
        rv.setAdapter(new ListaAdapter(produtosFiltrados));

    }
}


