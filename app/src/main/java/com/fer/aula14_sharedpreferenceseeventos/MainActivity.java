package com.fer.aula14_sharedpreferenceseeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnAvancar, btnOK;
    TextView resposta;
    EditText entrada;
    String texto;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main_portrait);
            btnOK = findViewById(R.id.btnOK);
        }else{
            setContentView(R.layout.activity_main_landscape);
            btnOK = findViewById(R.id.btn2OK);
        }
        btnAvancar = findViewById(R.id.btnProx);
        resposta = findViewById(R.id.txtSaida);
        entrada = findViewById(R.id.edTexto);

        prefs = getSharedPreferences("texto",MODE_PRIVATE);
        texto = prefs.getString("texto","Texto Aqui!!");
        resposta.setText(texto);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = entrada.getText().toString();
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("texto", texto);
                editor.apply();
                resposta.setText(texto);
            }
        });
        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SegundaTela.class);
                startActivity(i);
                finish();
            }
        });

    }
}