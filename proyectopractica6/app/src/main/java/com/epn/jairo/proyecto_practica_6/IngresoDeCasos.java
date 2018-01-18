package com.epn.jairo.proyecto_practica_6;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class IngresoDeCasos extends AppCompatActivity {



    private Calendar calendar;
    private TextView date_init;
    private TextView date_end;
    private int year, month, day;

    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_de_casos);
        Intent intent = getIntent();
       // this.db = (DatabaseHandler) intent.getSerializableExtra("mi_base");
        this.db = ((ProyectoSeis)this.getApplication()).db;

        date_init = (TextView)findViewById(R.id.textViewFechaInicio);
        date_end = (TextView)findViewById(R.id.textViewFechaFin);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate("inicio",year, month+1, day);
        showDate("fin",year, month+1, day);
    }


    private Caso get_layout_caso(){
        EditText cliente = findViewById(R.id.editTextCliente);
        Spinner spinnerEstado = (Spinner)findViewById(R.id.spinnerEstado);

        return new Caso(cliente.getText().toString()
                ,date_init.getText().toString()
                ,date_end.getText().toString()
                ,String.valueOf(spinnerEstado.getSelectedItem()));

    }

    public void guardar_caso(View view){
        Caso caso = get_layout_caso();
        //DatabaseHandler db = new DatabaseHandler(this);
        db.addCase(caso);

    }


    @SuppressWarnings("deprecation")
    public void set_date_init(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(),"Seleccion de Fecha",
                Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("deprecation")
    public void set_date_end(View view) {
        showDialog(1000);
        Toast.makeText(getApplicationContext(),"Seleccion de Fecha",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, DateListener_Init, year, month, day);
        }
        if(id == 1000){
            return new DatePickerDialog(this, DateListener_End, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener DateListener_End =
            new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

            showDate("fin", arg1, arg2+1, arg3);
        }
    };

    private DatePickerDialog.OnDateSetListener DateListener_Init = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3)
                {
                    showDate("inicio", arg1, arg2+1, arg3);
                }
            };

    private void showDate(String target, int year, int month, int day) {
        if(target.equals("inicio")){
            date_init.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));

        }
        if(target.equals("fin")){
            date_end.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
        }

    }



}
