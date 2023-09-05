package com.example.semesterregistration;

import android.content.Context;
import android.widget.ArrayAdapter;

public class YearAdapter extends ArrayAdapter<Integer> {
    public YearAdapter(Context context, int resource, Integer[] years) {
        super(context, resource, years);
    }
   
}

