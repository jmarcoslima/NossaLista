package com.example.nossalista.ui.uteis;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nossalista.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    //Declaração dos objetos para cada componente do layout_item.xml
    TextView txNomeLista;
    ImageView imgList;


    //Construtor
    public ViewHolder(View itemView) {
        super(itemView);
        //Vinculação dos objetos com os respectivos IDs
        txNomeLista = itemView.findViewById(R.id.txNomeList);
        imgList = itemView.findViewById(R.id.imgList);

    }


}
