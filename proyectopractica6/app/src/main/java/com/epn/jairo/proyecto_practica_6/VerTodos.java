package com.epn.jairo.proyecto_practica_6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VerTodos extends AppCompatActivity {
    DatabaseHandler db;
    private ListView listView;
    private Context contexto;
    private ArrayList<String> listViewItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_todos);
        contexto = this;
        this.db = ((ProyectoSeis)this.getApplication()).db;
        listView = (ListView)findViewById(R.id.mainListView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listViewItems);
        listView.setAdapter(adapter);

        final ArrayList<Caso> casos = this.db.get_all_casos();
        for (Caso caso: casos){
            adapter.add(caso.get_cliente());
        }

        adapter.notifyDataSetChanged();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position,
                                    long id) {
                Caso selectedcaso = casos.get(position);
                Intent intent = new Intent(contexto,ResultadoList.class);
                intent.putExtra("id",selectedcaso.get_id()+"");
                intent.putExtra("cliente",selectedcaso.get_cliente());
                intent.putExtra("fechainicio",selectedcaso.get_fecha_inicio());
                intent.putExtra("fechafin",selectedcaso.get_fecha_fin());
                intent.putExtra("estado",selectedcaso.get_estado());
                startActivity(intent);

            }
        });


    }
}
