package com.android_lab.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView ACTV;
    Spinner spinner;
    String[] weekdays={monday,tuesday,wenesday,thursday,friday,saturday,sunday};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ACTV=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        spinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter1= new



    }
}
