package com.epn.jairo.proyectopractica13;

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

    public void open_consulta(View view){
        Intent intent = new Intent(this,ConsultaCasos.class);
        startActivity(intent);
    }
}
