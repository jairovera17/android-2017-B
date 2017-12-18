package com.epn.jairo.proyecto_practica_6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by Jairo on 17/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "caseManager";
    public static final String TABLE_CASES = "cases";

    public static final String KEY_ID = "id";
    public static final String KEY_CLIENTE = "cliente";
    public static final String KEY_START_DATE = "start_date";
    public static final String KEY_END_DATE = "end_date";
    public static final String KEY_STATE = "state";


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CASES_TABLE = "CREATE TABLE " + TABLE_CASES +"("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CLIENTE + " TEXT,"
                + KEY_START_DATE + " TEXT," + KEY_END_DATE +" TEXT,"
                + KEY_STATE + " TEXT"+")";
        Log.d("creando tabla:",CREATE_CASES_TABLE);
        db.execSQL(CREATE_CASES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version) {
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASES);
        onCreate(db);
    }

    public void addCase(Caso caso){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CLIENTE, caso.get_cliente());
        values.put(KEY_START_DATE, caso.get_fecha_inicio());
        values.put(KEY_END_DATE, caso.get_fecha_fin());
        values.put(KEY_STATE, caso.get_estado());
        db.insert(TABLE_CASES, null, values);
        db.close();

    }

    public Caso getCaso(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CASES
                ,new String[]{KEY_ID,KEY_CLIENTE,KEY_START_DATE,KEY_END_DATE,KEY_STATE}
                , KEY_ID+"=?"
                ,new String[]{String.valueOf(id)}
                ,null
                ,null
                ,null
                ,null);
        if(cursor !=null){
            cursor.moveToFirst();
        }
        Caso caso = new Caso(Integer.parseInt(cursor.getString(0))
                ,cursor.getString(1)
                ,cursor.getString(2)
                ,cursor.getString(3)
                ,cursor.getString(4));
        db.close();
        return caso;
    }


}
