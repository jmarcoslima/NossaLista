package com.example.nossalista.Classes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.R;
import com.example.nossalista.teste.CarrinhoTeste;

import java.util.Arrays;
import java.util.List;

import static com.example.nossalista.teste.CarrinhoTeste.produtos;

public class ListaProdutosActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        rv = findViewById(R.id.rv);
        CarrinhoTeste ct = new CarrinhoTeste();

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
       // rv.setAdapter(new ListaAdapter(produtos));



    }

    /*private List<Produto> adicionarProdutos(){
        return Arrays.asList(

        );}

     */
}
