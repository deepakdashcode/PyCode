package com.deepak.py_code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

//    private TextView display;
    static String output;
    private TextView line_number;
    private EditText mainCode,input;
    private Button runCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        line_number=(TextView)findViewById(R.id.tvCountLines);
        mainCode=(EditText)findViewById(R.id.etMainCode);
        input=(EditText)findViewById(R.id.etInput);
        runCode=(Button)findViewById(R.id.btnRun);

        mainCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int lines=mainCode.getLineCount();

                String numberLines="";
                for(int k=1;k<=lines;k++)
                {
                    numberLines+=k+"\n";
                }
                line_number.setText(numberLines);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        display=(TextView)findViewById(R.id.tvDisplay);



        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        runCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py= Python.getInstance();

                PyObject pyObject=py.getModule("myScript");

                PyObject obj=pyObject.callAttr("main",mainCode.getText().toString(),input.getText().toString());




                output=obj.toString();

                Intent intent=new Intent(MainActivity.this,outputActivity.class);
                startActivity(intent);
            }
        });

    }
}