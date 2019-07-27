package com.android_lab.app_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner foreground, background;
    private TextView textView;

    private int[] options = {R.color.white, R.color.black, R.color.gray, R.color.red, R.color.green, R.color.blue};

    private final String MyPrefs = "MyPrefs";
    private final String FColor = "ForegroundColor";
    private final String BColor = "BackgroundColor";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        textView = findViewById(R.id.textView);
        foreground = findViewById(R.id.foreground);
        background = findViewById(R.id.background);

        foreground.setSelection(sp.getInt(FColor, 1));
        background.setSelection(sp.getInt(BColor, 0));

        foreground.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setTextColor(getResources().getColor(options[i]));

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FColor, i);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        background.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                findViewById(android.R.id.content).setBackgroundResource(options[i]);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(BColor, i);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }
}
