package com.epn.jairo.proyecto_practica_5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insertar","Insertando");
        db.addContact(new Contact("JAIRO VERA","1234567890"));
        Log.d("Insertar JAIROVERA","Success");
        db.addContact(new Contact("BBB","987654321"));
        Log.d("Insert BBB","Success");
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        Log.d("Reading","Reading all contacts...");
        List<Contact> contacts = db.getAllContacts();
        for(Contact cn:contacts){
            String log = "ID: "+cn.getID()+" ,Name: "+cn.getName()+" ,Phone: "+
                    cn.getPhoneNumber();
            Log.d("Name",log);
        }
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        Log.d("Update:","BBB-> CCC");
        Contact contact1 = db.getContact(2);
        Log.d("Old Contact", contact1.getName());
        contact1.setName("CCC");
        contact1.setPhoneNumber("456798132");
        Log.d("New Contact",contact1.getName());
        db.updateContact(contact1);
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        Log.d("Deleting: ","Deleting all contacts...");
        for(Contact c:contacts){
            String log = "ID: "+c.getID()+" ,Name:"+c.getName()
                    +" ,Phone"+c.getPhoneNumber();
            Log.d("Delete",log);
            db.deleteContact(c);
        }


    }

    public void writeFile(View view){
        String filename = "myfile";
        FileOutputStream outputStream;
        String string = "Sistemas sistemas sistemas sistemas";
        try{
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
            Log.d("Error", "writeFile: File not found");
        }
    }

    public void readfile(View view){
        String filename = "myfile";
        FileInputStream inputStream;

        try{
            inputStream = openFileInput(filename);

            byte fileContent[] = new byte[(int) inputStream.getChannel().size()];
            inputStream.read(fileContent);
            String s = new String(fileContent);
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(s);
        }catch (Exception e){
            e.printStackTrace();
            Log.d("Error", "readFile: File not found");
        }
    }


}
