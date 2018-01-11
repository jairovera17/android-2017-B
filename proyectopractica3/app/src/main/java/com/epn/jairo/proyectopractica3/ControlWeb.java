package com.epn.jairo.proyectopractica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ControlWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_web);

        String url_destino = getIntent().getStringExtra("direccion");
        WebView myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.loadUrl(url_destino);
    }
}
