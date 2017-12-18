package com.epn.jairo.proyecto_practica_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IngresoDeCasos extends AppCompatActivity {

    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_de_casos);
        Intent intent = getIntent();
       // this.db = (DatabaseHandler) intent.getSerializableExtra("mi_base");
        this.db = ((ProyectoSeis)this.getApplication()).db;
    }


    private Caso get_layout_caso(){
        EditText cliente = findViewById(R.id.editTextCliente);
        EditText fecha_inicio = findViewById(R.id.editTextFechaInicio);
        EditText fecha_fin = findViewById(R.id.editTextFechaFin);
        EditText estado = findViewById(R.id.editTextEstado);

        return new Caso(cliente.getText().toString()
                ,fecha_inicio.getText().toString()
                ,fecha_fin.getText().toString()
                ,estado.getText().toString());
    }

    public void guardar_caso(View view){
        Caso caso = get_layout_caso();
        //DatabaseHandler db = new DatabaseHandler(this);
        db.addCase(caso);

    }
}
