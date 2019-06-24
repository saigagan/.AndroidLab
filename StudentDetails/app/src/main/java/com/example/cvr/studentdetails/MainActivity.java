package com.example.cvr.studentdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.ClickListener{

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager layoutManager;

    private ArrayList<Student> dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(dataset, this);
        recyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onClick(int position) {
        Student student = dataset.get(position);
        Intent intent = new Intent(this, StudentDetails.class);
        intent.putExtra("student", student);
        startActivity(intent);
    }

    private void loadData() {
        dataset.add(new Student(55, "Sai Hemanth Bheemreddy", "15/07/1999"));
        dataset.add(new Student(51, "Sai Bhargav","15/07/2000"));
        dataset.add(new Student(56, "Sai Hitesh"));
        dataset.add(new Student(32, "Nikhil Tadikonda"));
        dataset.add(new Student(02, "Krishan Kalyan", "01/10/1999"));
    }
}
