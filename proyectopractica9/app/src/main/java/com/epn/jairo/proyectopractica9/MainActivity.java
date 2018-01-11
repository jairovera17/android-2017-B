package com.epn.jairo.proyectopractica9;

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

    public void open_buscar(View view){
        Intent intent = new Intent(this, ControlWeb.class);
        startActivity(intent);
    }
}
