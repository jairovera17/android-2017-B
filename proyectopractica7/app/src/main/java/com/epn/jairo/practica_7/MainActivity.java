package com.epn.jairo.practica_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> listViewItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.mainListView);
        adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listViewItems);
        listView.setAdapter(adapter);
        adapter.add("cosa 1");
        adapter.add("cosa 2");
        adapter.add("cosa 3");
        adapter.notifyDataSetChanged();





    }
}
