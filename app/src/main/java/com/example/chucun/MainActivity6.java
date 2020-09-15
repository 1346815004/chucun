package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1,tv2;
    Button btn1;
    String xuehao_1,xingming_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);

        final SharedPreferences sp = getSharedPreferences("test",MODE_PRIVATE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuehao_1 = et1.getText().toString();
                xingming_1 = et2.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("xuehao",xuehao_1);
                editor.putString("xingming",xingming_1);
                editor.commit();
                Toast.makeText(MainActivity6.this,"储存成功",Toast.LENGTH_SHORT).show();

                String  xuehao = sp.getString("xuehao",null);
                String  xingming = sp.getString("xingming",null);
                tv1.setText(xuehao);
                tv2.setText(xingming);
            }
        });
    }
}