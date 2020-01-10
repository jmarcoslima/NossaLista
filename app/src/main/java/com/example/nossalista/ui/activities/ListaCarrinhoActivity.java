package com.example.nossalista.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.example.nossalista.R;
import com.example.nossalista.ui.activities.CarrinhoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class ListaCarrinhoActivity extends AppCompatActivity {

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrinho);
        Intent intent = getIntent();


    }

   /* private void AbrirLista() {
        CardView CV = findViewById(R.id.cv);
        CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaCarrinhoActivity.this, CarrinhoActivity.class);
                startActivity(intent);
            }
        });
    }

    */

}