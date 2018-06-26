package com.example.tony.academia.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tony.academia.Classes.Usuario;
import com.example.tony.academia.DAO.ConfiguraçaoFirebase;
import com.example.tony.academia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenticacao;
    private EditText edtEmailLogin;
    private EditText edtSenhaLogin;
    private Button btnLogin;
    private Usuario usuario;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmailLogin = (EditText) findViewById(R.id.edtEmail);
        edtSenhaLogin = (EditText) findViewById(R.id.edtSenhalogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        if (usuarioLogado()){

            Intent intentMinhaConta = new Intent(MainActivity.this, menu_adm.class);
            abrirNovaActivity(intentMinhaConta);

        }else {


            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!edtEmailLogin.getText().toString().equals("") && !edtSenhaLogin.getText().toString().equals("")) {

                        usuario = new Usuario();

                        usuario.setEmail(edtEmailLogin.getText().toString());
                        usuario.setSenha(edtSenhaLogin.getText().toString());

                        validarLogin();

                    } else {
                        Toast.makeText(MainActivity.this, "preencha todos os campos", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

    private void validarLogin(){
        autenticacao = ConfiguraçaoFirebase.getFirebaseAuth();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail().toString(),usuario.getSenha().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    abrirTelaPrincipal();
                    Toast.makeText(MainActivity.this,"Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,"usuario ou senha invalido!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void abrirTelaPrincipal(){
        Intent intent = new Intent(MainActivity.this, menu_adm.class);
        startActivity(intent);
    }
    public Boolean usuarioLogado(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user !=null){
            return true;
        }else{
            return false;
        }
    }
    public void abrirNovaActivity (Intent intent){
        startActivity(intent);
    }
}
