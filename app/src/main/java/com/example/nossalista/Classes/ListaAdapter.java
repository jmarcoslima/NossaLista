package com.example.nossalista.Classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.Classes.Produto;
import com.example.nossalista.R;

import java.io.File;
import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    List<Produto> produtos;

    public ListaAdapter(List<Produto> produtos) {
        this.produtos = produtos;
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

        holder.textNome.setText(produtos.get(position).getNome() + ", "
        + (produtos.get(position).getCategoria()));

        //Pega uri da imagem e faz aparecer na lista
        File imgFile = new  File(produtos.get(position).getUri());
        if(imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.imageFoto.setImageBitmap(myBitmap);
        }
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private ImageView imageFoto;
        private ImageButton btnAdd, btnDel;

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.nome);
            imageFoto = itemView.findViewById(R.id.fotoproduto);

            btnAdd = itemView.findViewById(R.id.btnadd);
            btnDel = itemView.findViewById(R.id.btndel);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int index = getAdapterPosition();
                    Produto p = produtos.get(index);

                    Item i = new Item(p);


                }
            });
        }


    }
}
