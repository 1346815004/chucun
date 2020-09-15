package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;

public class zhuye extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);

        Onclick o1 = new Onclick();
        btn1.setOnClickListener(o1);
        btn2.setOnClickListener(o1);
        btn3.setOnClickListener(o1);
        btn4.setOnClickListener(o1);
        btn5.setOnClickListener(o1);
        btn6.setOnClickListener(o1);
        btn7.setOnClickListener(o1);

    }

    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn1:
                    intent = new Intent(zhuye.this,MainActivity.class);
                    break;
                case R.id.btn2:
                    intent = new Intent(zhuye.this,MainActivity2.class);
                    break;
                case R.id.btn3:
                    intent = new Intent(zhuye.this,MainActivity3.class);
                    break;
                case R.id.btn4:
                    intent = new Intent(zhuye.this,MainActivity4.class);
                    break;
                case R.id.btn5:
                    intent = new Intent(zhuye.this,MainActivity5.class);
                    break;
                case R.id.btn6:
                    intent = new Intent(zhuye.this,MainActivity6.class);
                    break;
                case R.id.btn7:
                    intent = new Intent(zhuye.this,MainActivity7.class);
                    break;
            }
            startActivity(intent);
        }
    }

}

