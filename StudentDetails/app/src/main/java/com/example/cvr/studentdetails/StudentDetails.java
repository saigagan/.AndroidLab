package com.example.cvr.studentdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    private TextView name, rollno, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        name = findViewById(R.id.student_name);
        rollno = findViewById(R.id.student_rollno);
        dob = findViewById(R.id.student_dob);

        Student student = (Student) getIntent().getSerializableExtra("student");
        name.setText(student.Name);
        rollno.setText(String.valueOf(student.rollno));
        dob.setText(student.dob);

        setTitle(student.Name);
    }
}
