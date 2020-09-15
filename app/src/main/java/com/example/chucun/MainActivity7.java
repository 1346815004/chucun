package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

public class MainActivity7 extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1,tv2;
    Button btn1,btn2;
    byte[] buffer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                FileInputStream fis1 = null;
                try {
                    fis = openFileInput("xuehao");
                    buffer = new byte[fis.available()];
                    fis.read(buffer);
                    String xuehao = new String(buffer);
                    tv1.setText(xuehao);

                    fis = openFileInput("xingming");
                    buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fis.close();
                    String xingming = new String(buffer);
                    tv2.setText(xingming);
                    Toast.makeText(MainActivity7.this,"查询成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                String xuehao = et1.getText().toString();
                String xingming = et2.getText().toString();
                try {
                    fos = openFileOutput("xuehao",MODE_PRIVATE);
                    fos.write(xuehao.getBytes());

                    fos = openFileOutput("xingming",MODE_PRIVATE);
                    fos.write(xingming.getBytes());

                    fos.flush();
                    fos.close();
                    Toast.makeText(MainActivity7.this,"储存成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}