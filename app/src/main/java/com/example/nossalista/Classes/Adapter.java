package com.example.nossalista.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    //Objetos globais da classe Adapter
    //Contexto da nossa aplicação
    private Context context;
    //Lista com dados a serem populados no RecyclerView
    private List<Historico> listas;

    public Adapter(List<Historico> listas, Context context) {
        this.listas = listas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflando o layout_item dentro de um objeto View
        View view = LayoutInflater.from(context).inflate(R.layout.activity_lista_card_view, viewGroup, false);
        //Acessando a nossa classe do ViewHolder e atribuindo o objeto View ao seu construtor
        ViewHolder VH = new ViewHolder(view);

        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
