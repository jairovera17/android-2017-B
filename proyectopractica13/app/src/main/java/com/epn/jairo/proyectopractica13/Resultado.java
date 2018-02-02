package com.epn.jairo.proyectopractica13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = this.getIntent();

        set_data(intent.getStringExtra("id"),
                intent.getStringExtra("name"),
                intent.getStringExtra("email"),
                intent.getStringExtra("address"),
                intent.getStringExtra("gender"));


    }


    private void set_data(String id,String name, String email,String address,String gender){
        ((TextView)findViewById(R.id.idTextView)).setText(id);
        ((TextView)findViewById(R.id.nameTextView)).setText(name);
        ((TextView)findViewById(R.id.emailTextView)).setText(email);
        ((TextView)findViewById(R.id.addressTextView)).setText(address);
        ((TextView)findViewById(R.id.genderTextView)).setText(gender);

    }

}
