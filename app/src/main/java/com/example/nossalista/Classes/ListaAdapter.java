package com.example.nossalista.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.R;
import com.example.nossalista.banco.Banco;

import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    private List<Produto> produtos;
    private Banco mydb;

    public ListaAdapter(Context context) {

        this.mydb = new Banco(context);
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);

        return new ListaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (produtos != null && produtos.size() > 0) ? produtos.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        holder.textNome.setText(produtos.get(position).getNome());

    }

    static class ListaViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private ImageView imageFoto;

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.nome);
            imageFoto = itemView.findViewById(R.id.fotoproduto);

        }
    }
}
