package com.android_lab.app_14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_CODE = 1;

    EditText phoneNo;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNo = findViewById(R.id.phoneNo);
        call = findViewById(R.id.call);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (phoneNo.getText().length() == 0) {
            Toast.makeText(this, "Phone Number not Entered", Toast.LENGTH_LONG).show();
            return;
        }


        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            callNumber();
        } else {
            requestPermission();
        }

    }

    private void requestPermission() {
        if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {

        } else {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    callNumber();
                else
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void callNumber() {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNo.getText()));
            startActivity(intent);
        }
    }
}
