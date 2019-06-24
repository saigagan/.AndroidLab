package com.example.cvr.studentdetails;

import java.io.Serializable;

/**
 * Created by cvr on 6/24/2019.
 */

public class Student implements Serializable {

    int rollno;
    String Name, dob;

    public Student(int rollno, String Name, String dob) {
        this.rollno = rollno;
        this.Name = Name;
        this.dob = dob;
    }

    public Student(int rollno, String Name) {
        this.rollno = rollno;
        this.Name = Name;
        this.dob = "N/A";
    }
}
