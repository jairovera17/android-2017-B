package com.epn.jairo.jairodev;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(getString(R.string.lastvalue), message);
        editor.commit();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void aboutMe(View view){
        Intent intent = new Intent(this, DisplayImageActivity.class);
        startActivity(intent);
    }

    public void lastValue(View view){

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String lastValue = sharedPref.getString(getString(R.string.lastvalue), "None");
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(lastValue);

    }

    public void saveKeyValue(View view){
        Intent intent = new Intent(this, LoadKeyValue.class);

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        SharedPreferences sharedPref2 =
                getSharedPreferences(getString(R.string.preference_file_key),
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putString(getString(R.string.lastvalue), message);
        editor2.commit();
        startActivity(intent);

    }

}
