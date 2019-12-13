package com.example.nossalista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nossalista.Classes.NavigationDrawerb;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        NavigationDrawerb nd = new NavigationDrawerb(this);


    }
}
