package com.android_lab.app_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_black:
                findViewById(android.R.id.content).setBackgroundResource(R.color.black);
                return true;
            case R.id.menu_white:
                findViewById(android.R.id.content).setBackgroundResource(R.color.white);
                return true;
            case R.id.menu_gray:
                findViewById(android.R.id.content).setBackgroundResource(R.color.gray);
                return true;
            case R.id.menu_red:
                findViewById(android.R.id.content).setBackgroundResource(R.color.red);
                return true;
            case R.id.menu_green:
                findViewById(android.R.id.content).setBackgroundResource(R.color.green);
                return true;
            case R.id.menu_blue:
                findViewById(android.R.id.content).setBackgroundResource(R.color.blue);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
