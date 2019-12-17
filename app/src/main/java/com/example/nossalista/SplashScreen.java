package com.example.nossalista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nossalista.teste.LoginActivity;

/**
 * Classe para a splash screen
 * Colocando todos os métodos que vou ultilizar na activity
 *
 * @author  Eduarda <eduarda.jen@gmail.com>
 */
public class SplashScreen extends AppCompatActivity {
    Animation moveimage;
    ImageView image;
    TextView texto;

    /**
     * Está criando uma nova Activity para implementar a Splash Screen
     * Mostrando a splash screen
     * Chamando a animacao da imagem
     * Ultilizando O Handler para fazer um encadeamento de Menssagem/Metodo
     * Ultilizando o Runnable para iniciar outra tarefa, no caso Mostra a ListaProdutosActivity
     * @param savedInstanceState
     * @return void
     * @author  Eduarda <eduarda.jen@gmail.com>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iniciaMain();
            }
        }, 5000);

        animacao();

    }
    /**
     * Inicia a main activity após o surgimento da splash sreen
     *
     * Utilizando a intent para iniciar a main activity.
     *
     * @return void
     *
     *
     */
    private void iniciaMain() {
        Intent intent = new Intent(
                SplashScreen.this, LoginActivity.class
        );
        startActivity(intent);
        finish();

    }
    /**Iniciando animações
     *
     * @return void
     */

    private void animacao() {
        image = findViewById(R.id.image);
        Animation AparecerTitulo = AnimationUtils.loadAnimation(this, R.anim.moveimage);
        image.startAnimation(AparecerTitulo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.explos);
        findViewById(R.id.tx).startAnimation(animation);
    }


}
