package com.example.chucun;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity3 extends AppCompatActivity {

    TextView tv1;
    EditText et1;
    Button btn1,btn2,btn3;
    byte[] buffer = null;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.tv1);

        try {

            File file1 = Environment.getExternalStorageDirectory();
            file = new File(file1,"test.text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity3.this,new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},1);


                FileOutputStream fos = null;
                String text = et1.getText().toString();
                try {
                    fos = new FileOutputStream(file);
                    fos.write(text.getBytes());
                    fos.flush();
                    Toast.makeText(MainActivity3.this,"存储成功",Toast.LENGTH_SHORT);
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
                    fis = new FileInputStream(file);
                    buffer = new byte[fis.available()];
                    fis.read(buffer);
                    Toast.makeText(MainActivity3.this,"读取成功",Toast.LENGTH_SHORT);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            for(int i=0; i<permissions.length; i++){
                if(permissions[i].equals("android.permission.WRITE_EXTERNAL_STORAGE") && grantResults[i]== PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"权限："+permissions[i]+"通过",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"权限："+permissions[i]+"失败",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}