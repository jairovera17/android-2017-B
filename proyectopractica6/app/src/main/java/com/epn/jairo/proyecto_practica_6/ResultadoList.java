package com.epn.jairo.proyecto_practica_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_list);
        Intent intent = getIntent();
        ((TextView)findViewById(R.id.textViewIDList))
                .setText(intent.getStringExtra("id"));
        ((TextView)findViewById(R.id.textViewClienteList))
                .setText(intent.getStringExtra("cliente"));
        ((TextView)findViewById(R.id.textViewFechaInicioList))
                .setText(intent.getStringExtra("fechainicio"));
        ((TextView)findViewById(R.id.textViewFechaFinList))
                .setText(intent.getStringExtra("fechafin"));
        ((TextView)findViewById(R.id.textViewEstadoList))
                .setText(intent.getStringExtra("estado"));
    }



}
