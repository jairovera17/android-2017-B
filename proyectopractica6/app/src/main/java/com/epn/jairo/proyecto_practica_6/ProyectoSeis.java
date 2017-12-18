package com.epn.jairo.proyecto_practica_6;

import android.app.Application;

/**
 * Created by Jairo on 17/12/2017.
 */

public class ProyectoSeis extends Application {
    DatabaseHandler db;
    @Override
    public void onCreate() {
        super.onCreate();
        db = new DatabaseHandler(this);
    }

}
