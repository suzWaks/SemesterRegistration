package com.example.semesterregistration;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String studentId = getIntent().getStringExtra("studentId");
        String name = getIntent().getStringExtra("name");
        String program = getIntent().getStringExtra("program");
        String ayear = getIntent().getStringExtra("ayear");
        String year = getIntent().getStringExtra("year");
        String semester = getIntent().getStringExtra("semester");
        String modules = getIntent().getStringExtra("modules");

        TextView displayTextView = findViewById(R.id.displayTextView);
        String displayText = "Student ID: " + studentId + "\n"
                + "Name: " + name + "\n"
                + "Program: " + program + "\n"
                + "Academic Year: " + ayear + "\n"
                + "Year: " + year + "\n"
                + "Semester: " + semester + "\n"
                + "Modules: " + modules;
        displayTextView.setText(displayText);

    }
}
