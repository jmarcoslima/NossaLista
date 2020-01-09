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

public class LoginActivity extends AppCompatActivity {
    private EditText editEmail, editSenha;
    private Button btLogin, btCadastro;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializaViews();
        eventosClick();
    }

    public void eventosClick(){
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                login(email,senha);
            }
            
        });
    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            alerta("Logado com sucesso!");
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            alerta("Campos incorretos!");
                        }
                    }
                });
    }

    private void alerta(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void inicializaViews(){
        editEmail = findViewById(R.id.email);
        editSenha = findViewById(R.id.senha);
        btLogin = findViewById(R.id.btLogin);
        btCadastro= findViewById(R.id.btCadastro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = ConexaoFB.getFirebaseAuth();
    }
}



