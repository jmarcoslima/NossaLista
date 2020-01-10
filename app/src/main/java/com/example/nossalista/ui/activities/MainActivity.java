package com.example.nossalista.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nossalista.R;
import com.example.nossalista.ui.uteis.NavigationDrawerb;
import com.example.nossalista.ui.uteis.Swipe;
import com.example.nossalista.dados.firebase.ConexaoFB;


public class MainActivity extends AppCompatActivity {

    RelativeLayout embacar;
    LinearLayout maincontent,mainmenu;
    ImageView btnMenu,avatar;
    Animation fromtop, frombottom;
    TextView nomeUser, tituloSobre, version;
    Button btListas, btCadastro, btSobre, btSair;
    private String categoria;
    private CardView cardCarne, cardBebida, cardHL, cardMercearia,
            cardHortifruti, cardGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        NavigationDrawerb nd = new NavigationDrawerb(this);

        instanciarViews();
        chamarBarra();
        swipeMenu();

        cardCarne = findViewById(R.id.cardCarne);
        cardBebida = findViewById(R.id.cardBebida);
        cardHL = findViewById(R.id.cardHL);
        cardMercearia = findViewById(R.id.cardMercearia);
        cardHortifruti = findViewById(R.id.cardHortifruti);
        cardGeral = findViewById(R.id.cardGeral);



        cardCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.carneefrios);
                iniciaLista();
            }
        });

        cardBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.bebidas);
                iniciaLista();
            }
        });

        cardHL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.higieneelimpeza);
                iniciaLista();
            }
        });

        cardMercearia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.mercearia);
                iniciaLista();
            }
        });

        cardHortifruti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.hortifruti);
                iniciaLista();
            }
        });

        cardGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                categoria = getString(R.string.geral);
                iniciaLista();
            }
        });
    }


    public void iniciaLista(){

        Intent intent = new Intent(this, ListaProdutosActivity.class);
        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }

    public void iniciaCarrinho(View view){

        Intent intent = new Intent(this, CarrinhoActivity.class);
        startActivity(intent);
    }


    private void instanciarViews() {
        //Button
        btListas = findViewById(R.id.btCarrinho);
        btCadastro = findViewById(R.id.btCadastro);
        btSobre = findViewById(R.id.btSobre);
        btSair = findViewById(R.id.btSair);

        //TextView
        nomeUser = findViewById(R.id.nomeUser);
        tituloSobre = findViewById(R.id.tituloSobre);
        version = findViewById(R.id.version);

        //ImageView
        avatar = findViewById(R.id.avatar);

        //Animações
        //fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        //frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        //Botão menuAsset pra testes
        btnMenu = findViewById(R.id.menu);

        maincontent = findViewById(R.id.mainContent);
        mainmenu = findViewById(R.id.mainmenu);
        embacar = findViewById(R.id.embacar);

    }

    /**
     *Metodo que tem o evento de click para abrir a barra pelo button
     *
     * @Since 1.0.0
     *
     * @return void
     **/
    public void chamarBarra() {


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenu();
            }
        });


    }
    public void telaCadastro(View view) {
        Intent i = new Intent(this, CadastroProdutoActivity.class);
        startActivity(i);

    }


    private void abrirMenu() {
        maincontent.animate().translationX(0);
        mainmenu.animate().translationX(0);
        embacar.setX(0);
        embacar.bringToFront();
        mainmenu.bringToFront();


      /*  //Iniciando as animações

        // de baixo
        btEdit.startAnimation(frombottom);
        btFavoritos.startAnimation(frombottom);
        btConfig.startAnimation(frombottom);
        btSobre.startAnimation(frombottom);
        btSair.startAnimation(frombottom);
        tituloSobre.startAnimation(frombottom);
        version.startAnimation(frombottom);

        //de cima
        avatar.startAnimation(fromtop);
        nomeUser.startAnimation(fromtop);
        email.startAnimation(fromtop);
=======

>>>>>>> Stashed changes


       */
    }

    private void fecharMenu() {
        //maincontent.animate().translationX(-800);
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);
    }

    private void btSair(View view){
        ConexaoFB.logOut();
        finish();

    }

    private void swipeMenu() {

        maincontent.setOnTouchListener(new Swipe(MainActivity.this) {

            public void onSwipeTop() {

                return;
            }

            public void onSwipeRight() {
                abrirMenu();
                return;

            }

            public void onSwipeLeft() {
                fecharMenu();
                return;
            }

            public void onSwipeBottom() {
                return;
            }
        });


    }
}

