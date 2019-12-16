package com.example.nossalista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nossalista.Classes.ListaProdutosActivity;
import com.example.nossalista.Classes.NavigationDrawerb;
import com.example.nossalista.Classes.Swipe;

public class MainActivity extends AppCompatActivity {
    RelativeLayout embacar;
    LinearLayout maincontent,mainmenu;
    ImageView btnMenu,avatar;
    Animation fromtop, frombottom;
    TextView nomeUser, tituloSobre, version;
    Button btListas, btCadastro, btSobre, btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        NavigationDrawerb nd = new NavigationDrawerb(this);
        LinearLayout card1 = findViewById(R.id.card1);

        instanciarViews();
        chamarBarra();
        swipeMenu();



    }


    public void iniciaLista(View view){
        Intent intent = new Intent(this, ListaProdutosActivity.class);
        startActivity(intent);

    }

    private void instanciarViews() {
        //Button
        btListas = findViewById(R.id.btListas);
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

        //Ao clicar fora da barra ela some

        /*maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/
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


       */
    }

    private void fecharMenu() {
        //maincontent.animate().translationX(-800);
        mainmenu.animate().translationX(-800);
        embacar.setX(1600);
    }


    private void swipeMenu() {
        maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });

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

