package com.deepak.py_code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class outputActivity extends AppCompatActivity {


    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        output=(TextView) findViewById(R.id.etOutput);



        output.setText(MainActivity.output);
        System.out.println("OUTPUT IS "+MainActivity.output);
    }
}