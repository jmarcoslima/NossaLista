package com.example.nossalista.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nossalista.R;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView rvCarrinho;
    private ItemDAO dao;
    private List<Item> itens;
    private List<Item> itensFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        dao = new ItemDAO(this);
        rvCarrinho = findViewById(R.id.rvCarrinho);
        itens = dao.meDAOsItens();

        itensFiltrados.addAll(itens);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rvCarrinho.setLayoutManager(lm);
        rvCarrinho.setAdapter(new CarrinhoAdapter(itensFiltrados));

        registerForContextMenu(rvCarrinho);
    }

    @Override
    public void onResume() {

        super.onResume();
        itens = dao.meDAOsItens();
        itensFiltrados.clear();
        itensFiltrados.addAll(itens);
        rvCarrinho.setAdapter(new CarrinhoAdapter(itensFiltrados));

    }
}

