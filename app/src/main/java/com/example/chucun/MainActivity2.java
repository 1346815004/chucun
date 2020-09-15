package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1;
    EditText et1;
    Button btn1,btn2,btn3;
    byte[] buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                String text = et1.getText().toString();
                try {
                    fos = openFileOutput("memo",MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                try {
                    fis = openFileInput("memo");
                    buffer = new byte[fis.available()];
                    fis.read(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                    String data = new String(buffer);
                    tv1.setText(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}