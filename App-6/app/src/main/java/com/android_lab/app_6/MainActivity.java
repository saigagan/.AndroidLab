package com.android_lab.app_6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ImageView imageView;

    private Drawable[] imageList = {R.drawable.turtlerock, R.drawable.silversalmoncreek, R.drawable.chilkoottrail,
            R.drawable.stmarylake, R.drawable.twinlake, R.drawable.lakemcdonald,
            R.drawable.yukon_charleyrivers, R.drawable.icybay, R.drawable.rainbowlake,
            R.drawable.hiddenlake, R.drawable.chincoteague, R.drawable.umbagog};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        imageView = findViewById(R.id.imageView);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Selected: " + i, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
