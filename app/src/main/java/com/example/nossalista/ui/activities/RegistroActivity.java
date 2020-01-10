package com.example.nossalista.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nossalista.R;
import com.example.nossalista.dados.firebase.ConexaoFB;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroActivity extends AppCompatActivity {
    private EditText editEmail, editSenha;
    private Button btRegistrar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaViews();
        eventosClick();
    }


    public void eventosClick() {
        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                criarUser(email, senha);

            }
        });
    }

    public void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            alerta("Usuário cadastrado com sucesso!");
                            Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();

                        } else {
                            alerta("Erro no cadastro");

                        }
                    }
                });

    }

    private void alerta(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    public void inicializaViews() {
        editEmail = findViewById(R.id.email);
        editSenha = findViewById(R.id.senha);
        btRegistrar = findViewById(R.id.btRegistrar);
    }

    protected void onStart() {
        super.onStart();
        auth = ConexaoFB.getFirebaseAuth();
    }
}
