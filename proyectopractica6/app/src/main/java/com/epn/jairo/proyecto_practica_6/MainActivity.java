package com.epn.jairo.proyecto_practica_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open_ingreso_de_casos(View view){
        Intent intent = new Intent(this,IngresoDeCasos.class);
        startActivity(intent);
    }

    public void open_consulta_de_casos(View view){
        Intent intent = new Intent(this,ConsultaDeCasos.class);
        startActivity(intent);
    }
}
