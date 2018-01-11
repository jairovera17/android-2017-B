package com.epn.jairo.proyectopractica3;

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

    public void open_historia(View view){
        Intent intent = new Intent(this, ControlWeb.class);
        intent.putExtra("direccion","http://www.epn.edu.ec/institucion/sintesis-historica/");
        startActivity(intent);
    }

    public void open_detalles(View view){
        Intent intent = new Intent(this, ControlWeb.class);
        intent.putExtra("direccion","https://es.wikipedia.org/wiki/Escuela_Polit%C3%A9cnica_Nacional");
        startActivity(intent);
    }
}
