package com.example.nossalista.Classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nossalista.R;

public class NavigationDrawerb extends FrameLayout {
    private Context mContext;
    private LayoutInflater layoutInflater;
    RelativeLayout embacar;
    LinearLayout mainmenu;
    Animation fromtop, frombottom;
    TextView nomeUser, tituloSobre, version;
    Button btEdit, btFavoritos, btConfig, btSobre, btSair;


    public NavigationDrawerb(Context context) {
        super(context);
        Log.d("TESTENAV","Construtor");
        this.mContext = context;
        Log.d("TESTENAV","Vai inflar");
        inflate();
        Log.d("TESTENAV","inflou");
        bindViews();
        Log.d("TESTENAV","bindou");    }

    private void inflate() {
        layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.navigation, this, true);
    }

    private void bindViews() {
        btEdit = findViewById(R.id.btEdit);
        btFavoritos = findViewById(R.id.btFavoritos);
        btConfig = findViewById(R.id.btConfig);
        btSobre = findViewById(R.id.btSobre);
        btSair = findViewById(R.id.btSair);

        //TextView
        nomeUser = findViewById(R.id.nomeUser);
        tituloSobre = findViewById(R.id.tituloSobre);
        version = findViewById(R.id.version);

        //ImageView

        //Animações
        //fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        //frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //Botão menuAsset pra testes

        mainmenu = findViewById(R.id.mainmenu);
        embacar = findViewById(R.id.embacar);


    }

    public void abrirMenu() {
        mainmenu.animate().translationX(0);
        embacar.setX(0);
        embacar.bringToFront();
        mainmenu.bringToFront();

        //Iniciando as animações

        // de baixo
        //btEdit.startAnimation(frombottom);
        //btFavoritos.startAnimation(frombottom);
        //btConfig.startAnimation(frombottom);
        ///btSobre.startAnimation(frombottom);
        //btSair.startAnimation(frombottom);
        //tituloSobre.startAnimation(frombottom);
        //version.startAnimation(frombottom);

        //de cima
        //avatar.startAnimation(fromtop);
        //nomeUser.startAnimation(fromtop);
        //email.startAnimation(fromtop);
    }

    private void fecharMenu() {
        //maincontent.animate().translationX(-800);
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);
    }

}






