package com.epn.jairo.proyecto_practica_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultadoDeBusqueda extends AppCompatActivity {

    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_de_busqueda);
        Intent intent = getIntent();
        this.db = ((ProyectoSeis)this.getApplication()).db;
        int index = intent.getIntExtra("index",0);
        Caso caso = db.getCaso(index);
        Log.d("caso final",caso.get_cliente()+" "+caso.get_estado());
        ((TextView)findViewById(R.id.textViewID)).setText(caso.get_id()+"");
        ((TextView)findViewById(R.id.textViewCliente)).setText(caso.get_cliente());
        ((TextView)findViewById(R.id.textViewFechaInicio)).setText(caso.get_fecha_inicio());
        ((TextView)findViewById(R.id.textViewFechaFin)).setText(caso.get_fecha_fin());
        ((TextView)findViewById(R.id.textViewEstado)).setText(caso.get_estado());


    }
}
