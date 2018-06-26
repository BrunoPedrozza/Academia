package com.example.tony.academia.Activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tony.academia.R;

public class cadastrousuario extends AppCompatActivity {
    private Button btncancelarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrousuario);
        btncancelarCadastro = (Button) findViewById(R.id.btnCancelarCadastro);

        btncancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cadastrousuario.this, menu_adm.class);
                startActivity(intent);
            }
        });

    }
    public void clikCadastrar (View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Usuario Cadastrado!");
        alertDialog.setMessage("voce Cadastrou o Usuario");
        alertDialog.show();



    }
}
