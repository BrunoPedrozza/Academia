package com.example.tony.academia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tony.academia.R;

public class vertreino extends AppCompatActivity {
    private Button btnvoltartreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertreino);

        btnvoltartreino= (Button) findViewById(R.id.btnVoltarTreino);

        btnvoltartreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vertreino.this, menualuno.class);
                startActivity(intent);
            }
        });
    }
}
