package com.example.tony.academia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tony.academia.R;

public class menualuno extends AppCompatActivity {
    private Button btnVertreino;
    private Button btnVerPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menualuno);
        btnVertreino = (Button) findViewById(R.id.btnvertreino);
        btnVerPerfil = (Button) findViewById(R.id.btnverperfil);

        btnVertreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menualuno.this, vertreino.class);
                startActivity(intent);
            }
        });
        btnVerPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menualuno.this, perfilaluno.class);
                startActivity(intent);
            }
        });
    }
}
