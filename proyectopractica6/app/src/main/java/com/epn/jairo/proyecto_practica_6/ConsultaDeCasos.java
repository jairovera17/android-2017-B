package com.epn.jairo.proyecto_practica_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ConsultaDeCasos extends AppCompatActivity {

    //DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_de_casos);
        Intent intent = getIntent();
        //this.db = ((ProyectoSeis)this.getApplication()).db;
    }

    public void resultados(View view){
        String index = ((EditText)findViewById(R.id.editTextIDSearch)).getText().toString();
        if (
                index.equals(null)
                || index.equals("")
                ){
            return;
        }
        else{
           // Caso caso = db.getCaso(Integer.parseInt(index));
            Intent intent = new Intent(this, ResultadoDeBusqueda.class);
            intent.putExtra("index",Integer.parseInt(index));
            startActivity(intent);
        }
    }


}
