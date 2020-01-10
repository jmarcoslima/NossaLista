package com.example.nossalista.ui.uteis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.R;
import com.example.nossalista.dados.systemofaDAO.ProdutoDAO;
import com.example.nossalista.entidades.Item;
import com.example.nossalista.entidades.Produto;
import com.example.nossalista.dados.systemofaDAO.ItemDAO;
import com.example.nossalista.ui.activities.ManipulaProdutoActivity;

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

        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_produto,
                    parent, false);

        return new ListaViewHolder(view);
    }

    @Override
    public int getItemCount() {

        return (produtos != null && produtos.size() > 0) ? produtos.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {

        holder.textNome.setText(produtos.get(position).getNome());

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
        private ImageButton btnAdd, btnDel, btnEdit;

        public ListaViewHolder(@NonNull final View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.nome);
            imageFoto = itemView.findViewById(R.id.fotoproduto);

            btnAdd = itemView.findViewById(R.id.btnadd);
            btnDel = itemView.findViewById(R.id.btndel);
            btnEdit = itemView.findViewById(R.id.btnedit);

            /**
             * Adiciona o produto no carrinho
             */
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Produto p = getProdutoSelecionado();

                    ItemDAO itemDAO = new ItemDAO(itemView.getContext());

                    /**
                     * Caso seja true o item é inserido na tabela.
                     */
                    if (itemDAO.inserirItem(new Item(p)) > 0) {

                        Toast.makeText(itemView.getContext(),
                                "Adicionado ao carrinho",
                                     Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(itemView.getContext(),
                                "Já foi adicionado ao carrinho",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });

            /**
             * Remove o produto do carrinho e da lista de produtos.
             */
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Produto p = getProdutoSelecionado();
                    ProdutoDAO produtoDAO = new ProdutoDAO(itemView.getContext());
                    produtoDAO.excluir(p);

                    Toast.makeText(itemView.getContext(),
                            "Produto removido",
                            Toast.LENGTH_SHORT).show();

                    /**
                     * remove do array que a RecyclerView usa para
                     * pegar info.
                     */
                    produtos.remove(p);

                    /**
                     * Atualiza a RecyclerView, excluindo da tela
                     * o produto.
                     */
                    notifyDataSetChanged();
                }
            });

            /**
             * Editar.
             */
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Produto p = getProdutoSelecionado();

                    Intent i = new Intent(itemView.getContext(),
                            ManipulaProdutoActivity.class);

                    /**
                     * manda na intent o id do Produto para manipular
                     * ele na outra activity
                     */
                    Bundle extras = new Bundle();
                    extras.putInt("idP", p.getId());
                    extras.putString("nomeP", p.getNome());
                    extras.putString("uriP",p.getUri());
                    extras.putString("categoriaP",p.getCategoria());
                    i.putExtras(extras);

                    itemView.getContext().startActivity(i);
                }
            });
        }

        /**
         *
         * @return produto que foi clicado.
         */
        public Produto getProdutoSelecionado(){

            return produtos.get(getAdapterPosition());
        }

    }
}
