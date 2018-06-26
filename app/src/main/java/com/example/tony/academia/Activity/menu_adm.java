package com.example.tony.academia.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.tony.academia.R;
import com.google.firebase.auth.FirebaseAuth;

public class menu_adm extends AppCompatActivity{
    private Button btnIrCadastroP;
    private Button btnEdtProfessor;
    private Button btnEdtAluno;
    private Button btnCadAluno;

    private FirebaseAuth autenticacao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);
        autenticacao = FirebaseAuth.getInstance();
        btnIrCadastroP = (Button) findViewById(R.id.btnIrCadastroP);
        btnEdtProfessor  = (Button) findViewById(R.id.btnedtprofessor);
        btnEdtAluno = (Button) findViewById(R.id.btnedtAluno);
        btnCadAluno = (Button) findViewById(R.id.btnCadAluno);

        btnIrCadastroP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_adm.this, cadastrousuario.class);
                startActivity(intent);
            }
        });
        btnEdtProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_adm.this, edtarperfilusuario.class);
                startActivity(intent);
            }
        });
        btnEdtAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_adm.this, edtarperfilusuario.class);
                startActivity(intent);
            }
        });
        btnCadAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_adm.this, cadastrousuario.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_editar_prof){
            editarProfessor();


        }else if (id== R.id.action_sair_admin){
            deslogarUsuario();

        }else if(id == R.id.action_editar_aluno){
            editarAluno();

        }



        return super.onOptionsItemSelected(item);
    }

    private void abrirTelaCadastro(){
        Intent intent = new Intent(menu_adm.this,cadastrousuario.class);
        startActivity(intent);

    }
    private void deslogarUsuario(){
        autenticacao.signOut();
        Intent intent = new Intent(menu_adm.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void editarAluno(){
        Intent intent = new Intent(menu_adm.this,editaraluno.class);
        startActivity(intent);

    }
    private void editarProfessor(){
        Intent intent = new Intent(menu_adm.this,editarprofessor.class);
        startActivity(intent);

    }
}

