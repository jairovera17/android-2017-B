package com.epn.jairo.proyectopractica12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.label);
    }

    public void makeRequest(View view){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");

            }
        });

        queue.add(stringRequest);
    }

    public void makeRequest2(View view){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url2
                ="http://hp-api.herokuapp.com/api/characters";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url2, null, new
                        Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                mTextView.setText("Response: " + response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText(error.toString());
                        /*mTextView.setText("abd"+ "Error: " + error
                                + ">>" + error.networkResponse.statusCode
                                + ">>" + error.networkResponse.data
                                + ">>" + error.getCause()
                                + ">>" + error.getMessage());*/


                    }
                });
        queue.add(jsObjRequest);
    }
}

