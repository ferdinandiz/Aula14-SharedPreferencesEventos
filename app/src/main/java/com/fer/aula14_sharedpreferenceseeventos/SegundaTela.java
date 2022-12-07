package com.fer.aula14_sharedpreferenceseeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {
    TextView txtPrincipal, txtSumir;
    float x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);
        txtPrincipal = findViewById(R.id.txtTouch);
        txtSumir = findViewById(R.id.txtSumimr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX() -50;
        y = event.getY() -100;
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            txtSumir.setVisibility(View.INVISIBLE);
            txtPrincipal.setBackgroundColor(Color.RED);
            txtPrincipal.setTranslationX(x);
            txtPrincipal.setTranslationY(y);
            txtPrincipal.setWidth(10);
            txtPrincipal.setHeight(10);
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            txtPrincipal.setTextColor(Color.MAGENTA);
            txtPrincipal.setWidth((int)x);
            txtPrincipal.setHeight((int)y);
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            txtPrincipal.setBackgroundColor(Color.BLUE);
            txtPrincipal.setWidth((int)x);
            txtPrincipal.setHeight((int)y);
        }
        return super.onTouchEvent(event);

    }
}