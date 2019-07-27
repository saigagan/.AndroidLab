package com.android_lab.app_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner foreground, background;
    private TextView textView;
    private int[] options = {R.color.white, R.color.black, R.color.gray, R.color.red, R.color.green, R.color.blue};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        foreground = findViewById(R.id.foreground);
        foreground.setOnItemSelectedListener(this);
        background = findViewById(R.id.background);
        background.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(view.getId()) {
            case R.id.foreground:
                textView.setTextColor(options[i]);
                break;
            case R.id.background:
                findViewById(android.R.id.content).setBackgroundResource(options[i]);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
