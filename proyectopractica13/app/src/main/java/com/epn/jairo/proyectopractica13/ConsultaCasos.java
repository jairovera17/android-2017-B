package com.epn.jairo.proyectopractica13;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsultaCasos extends AppCompatActivity {


    private ListView listView;
    private ArrayList<String> listViewItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private Context contexto_aux;

    private ArrayList<Contacto> all_contacts = new ArrayList<>();

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_casos);
        listView = (ListView)findViewById(R.id.mainListView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listViewItems);
        listView.setAdapter(adapter);
        contexto_aux = this;
        mTextView = (TextView)findViewById(R.id.mTextView);
        adapter.notifyDataSetChanged();

        this.consultContacts();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position,
                                    long id) {
                String pos = listViewItems.get(position);
                Toast.makeText(getApplicationContext(),pos, Toast.LENGTH_LONG).show();

                for (Contacto contacto: all_contacts){
                    Log.d("haber",pos+"  vs  "+contacto.name);
                    if (pos.equals(contacto.name)){
                        Intent intent = new Intent(contexto_aux, Resultado.class);
                        intent.putExtra("id",contacto.id);
                        intent.putExtra("name",contacto.name);
                        intent.putExtra("address",contacto.address);
                        intent.putExtra("email",contacto.email);
                        intent.putExtra("gender",contacto.gender);

                        startActivity(intent);

                    }
                }
            }
        });

    }
    public void consultContacts(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url2 ="https://api.androidhive.info/contacts/";

        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url2, null, new
                        Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject jsonObj = new JSONObject(response.toString());
                                    JSONArray contacts = jsonObj.getJSONArray("contacts");
                                    for (int i = 0; i < contacts.length(); i++) {
                                        JSONObject c = contacts.getJSONObject(i);
                                        String id = c.getString("id");
                                        String name = c.getString("name");
                                        String email = c.getString("email");
                                        String address = c.getString("address");
                                        String gender = c.getString("gender");

                                        Contacto nuevo_contacto = new Contacto(id,name,email,address,gender);
                                        all_contacts.add(nuevo_contacto);
                                        adapter.add(name);
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                                catch (final JSONException e) {
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("No sirvio");
                    }
                });
        queue.add(jsObjRequest);
    }

}
