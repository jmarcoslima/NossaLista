package com.example.nossalista.Classes;

import android.os.Bundle;

import com.example.nossalista.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;



public class ListaFinal extends AppCompatActivity {

    ArrayList<TesteProduto> produto;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_final);
        rv = findViewById (R.id.rvFinal);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        produto = new ArrayList<TesteProduto>();
        produto.add(new TesteProduto("Pespi"));
        produto.add(new TesteProduto("Sukita"));
        produto.add(new TesteProduto("Melao"));
        produto.add(new TesteProduto("Biscoito"));
        produto.add(new TesteProduto("Bala"));

        rv.setAdapter(new ListaAdapter(produto));







    }












}

