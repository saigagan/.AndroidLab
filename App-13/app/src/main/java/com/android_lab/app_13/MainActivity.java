package com.android_lab.app_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.ClickListener {

    private static final int REQUEST_READ_SMS = 01;
    RecyclerView recyclerView;
    private MyAdapter adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<Message> sms  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(sms,this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
            readMessages();
        } else {
            requestPermission();
        }
    }

    private void requestPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, REQUEST_READ_SMS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_SMS:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    readMessages();
                else
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                return;
                
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void readMessages() {
        ContentResolver contentResolver = getContentResolver();
        Cursor c = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (((c != null) ? c.getCount() : 0) > 0) {
            while (c != null && c.moveToNext()) {
                String address = c.getString(c.getColumnIndex(Telephony.Sms.ADDRESS));
                String body =  c.getString(c.getColumnIndex(Telephony.Sms.BODY));
                sms.add(new Message(address, body));
            }
        } else {
            sms.add(new Message("No Message on Your Device", ""));
        }

        if (c != null) {
            c.close();
        }

        adapter.dataset = sms;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(int position) {
        Message m = sms.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m.body)
                .setTitle(m.address+"\n")
                .setNeutralButton("Done", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
        builder.create().show();
    }
}
