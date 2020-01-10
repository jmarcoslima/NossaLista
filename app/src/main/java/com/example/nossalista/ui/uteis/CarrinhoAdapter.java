package com.example.nossalista.ui.uteis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.nossalista.dados.systemofaDAO.ItemDAO;
import com.example.nossalista.entidades.Produto;

import java.io.File;
import java.util.List;

/**
 * Adapter da RecyclerView da activity CarrinhoActivity.
 *
 * A classe lista produtos porque a classe Item serve apenas para
 * pegar os produtos que foram selecionados.
 *
 * @author Diego <diego.santos@hbsis.com.br>
 */

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    /**
     * Lista para inflar a RecyclerView
     */
    List<Produto> produtosSelecionados;

    /**
     * Construtor.
     *
     * @param produtosSelecionados é a lista de todos os produtos que foram
     *                             selecionados e inseridos na tabela item (ver classe Conexao
     *                             no pacote de dados/persistencia). Para pegar esses produtos
     *                             se deve usar o método listar na classe ItemDAO (pacote
     *                             dados/systemofaDAO).
     *
     */
    public CarrinhoAdapter(List<Produto> produtosSelecionados) {

        this.produtosSelecionados = produtosSelecionados;
    }

    /**
     * Instancia o ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_carrinho,
                   parent, false);

        return new CarrinhoViewHolder(view);
    }

    /**
     * Vai inflando a lista conforme necessário.
     *
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {

        holder.getTextNome().setText(produtosSelecionados.get(position).getNome());

        File imgFile = new  File(produtosSelecionados.get(position).getUri());

        if(imgFile.exists()) {

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.getImageFoto().setImageBitmap(myBitmap);
        }
    }

    @Override
    public int getItemCount() {

        return produtosSelecionados.size();
    }

    /**
     * Classe que mantém os ids que serão inflados.
     *
     * @author Diego <diego.santos@hbsis.com.br>
     */

    public class CarrinhoViewHolder extends RecyclerView.ViewHolder{

        private TextView textNome;
        private ImageView imageFoto;
        private ImageButton btnDel;

        public CarrinhoViewHolder(@NonNull final View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.nome_item);
            imageFoto = itemView.findViewById(R.id.foto_item);
            btnDel = itemView.findViewById(R.id.btndel_item);

            /**
             * Método para deletar o item selecionado do carrinho.
             *
             * @author Diego <diego.santos@hbsis.com.br>
             */
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /**
                     * Se instancia o ItemDAO para poder fazer as
                     * operações necessárias no banco.
                     */
                    ItemDAO itemDAO = new ItemDAO(itemView.getContext());
                    Produto p = produtosSelecionados.get(getAdapterPosition());

                    /**
                     * exclui da tabela item
                     */
                    itemDAO.excluir(p);

                    Toast.makeText(itemView.getContext(),
                            "Item removido",
                            Toast.LENGTH_SHORT).show();

                    /**
                     * remove do ArrayList que a RecyclerView usa para inflar
                     */
                    produtosSelecionados.remove(p);

                    /**
                     * atualiza a lista, removendo o item que foi excluido
                     * anteriormente
                     */
                    notifyDataSetChanged();
                }
            });
        }

        public TextView getTextNome() {
            return textNome;
        }

        public ImageView getImageFoto() {
            return imageFoto;
        }

        public ImageButton getBtnDel() {
            return btnDel;
        }
    }
}
