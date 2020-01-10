package com.example.nossalista.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nossalista.R;
import com.example.nossalista.ui.uteis.CarrinhoAdapter;
import com.example.nossalista.ui.uteis.ListaAdapter;
import com.example.nossalista.entidades.Produto;
import com.example.nossalista.dados.systemofaDAO.ItemDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity do carrinho, lista os itens.
 *
 * @author Diego <diego.santos@hbsis.com.br>
 */

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView rvCarrinho;
    private ItemDAO dao;
    private List<Produto> produtosSelecionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        dao = new ItemDAO(this);
        rvCarrinho = findViewById(R.id.rvCarrinho);

        /**
         * pega todos os itens salvos no banco e joga num ArrayList.
         */
        produtosSelecionados = new ArrayList<Produto>(dao.listar());

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rvCarrinho.setLayoutManager(lm);

        /**
         * Seta o adapter para a RecyclerView poder ser inflada.
         */
        rvCarrinho.setAdapter(new CarrinhoAdapter(produtosSelecionados));

        registerForContextMenu(rvCarrinho);
    }
}

