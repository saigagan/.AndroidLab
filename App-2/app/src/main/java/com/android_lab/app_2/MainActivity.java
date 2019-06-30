package com.android_lab.app_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;


    // username: cvrcsec
    // password: password
    private static String uname = "cvrcsec";
    private static String passwd = "b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.current_username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String uname = username.getText().toString();
        String passwd = hashPassword(password.getText().toString());

        if(uname.equals(MainActivity.uname) && passwd.equals(MainActivity.passwd)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.putExtra("username", uname);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid Username/Password.", Toast.LENGTH_LONG).show();
        }
    }

    private String hashPassword(String passwd) {
        String hashedPasswd = "";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] bytes = md.digest(passwd.getBytes());
            StringBuilder sb = new StringBuilder();

            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashedPasswd = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPasswd;
    }
}
