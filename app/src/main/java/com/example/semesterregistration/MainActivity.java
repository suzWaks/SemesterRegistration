package com.example.semesterregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        //Submit Button
        Button sub = findViewById(R.id.button);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = ((EditText) findViewById(R.id.student_id)).getText().toString();
                String name = ((EditText) findViewById(R.id.editTextText)).getText().toString();
                String program = ((Spinner) findViewById(R.id.prgm)).getSelectedItem().toString();
                String ayear = ((Spinner) findViewById(R.id.yearSpinner)).getSelectedItem().toString();
                String semester = ((Spinner) findViewById(R.id.sem)).getSelectedItem().toString();
                String modules = ((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString();

                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                String year = "";
                if (selectedRadioButton != null) {
                    year = selectedRadioButton.getText().toString();
                }

                Intent intent = new Intent(MainActivity.this, Display.class);
                intent.putExtra("studentId", studentId);
                intent.putExtra("name", name);
                intent.putExtra("program", program);
                intent.putExtra("ayear", ayear);
                intent.putExtra("year", year);
                intent.putExtra("semester", semester);
                intent.putExtra("modules", modules);
                startActivity(intent);

            }
        });

            //Programme
        Spinner spinner = findViewById(R.id.prgm);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.prgm, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //Semester
        Spinner spin = findViewById(R.id.sem);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this,
                R.array.sem, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adap);

        //Academic Year
        Spinner yearSpinner = findViewById(R.id.yearSpinner);
        Integer[] years = generateYears(2020, 2050);
        // Create an adapter and set it to the Spinner
        ArrayAdapter<Integer> yearAdapter = new YearAdapter(this, android.R.layout.simple_spinner_item, years);
        yearSpinner.setAdapter(yearAdapter);
    }

    private Integer[] generateYears(int startYear, int endYear) {
        int yearCount = endYear - startYear + 1;
        Integer[] years = new Integer[yearCount];
        for (int i = 0; i < yearCount; i++) {
            years[i] = startYear + i;
        }
        return years;
    }
}

