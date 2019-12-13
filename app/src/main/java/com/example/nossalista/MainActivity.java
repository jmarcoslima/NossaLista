package com.example.nossalista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nossalista.Classes.Categoria;
import com.example.nossalista.banco.Operacoes;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operacoes op = new Operacoes(this);

        op.insert("Banana");

        tv = findViewById(R.id.tv);

        //String s =  op.select("1");
        Categoria c = op.select("2");

        tv.setText(c.getNome());
    }
}
