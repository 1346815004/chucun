package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String ming = "ming", mi = "mi";
    EditText user,pass;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btn1 = findViewById(R.id.btn1);

        final SharedPreferences sp = getSharedPreferences("mrsoft",MODE_PRIVATE);
        String username = sp.getString("username",null);
        String passworld = sp.getString("passworld",null);
        if(username!=null && passworld!=null){
            if(username.equals(ming) && passworld.equals(mi)){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        }else{
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username_1 = user.getText().toString();
                    String passworld_1 = pass.getText().toString();
                    SharedPreferences.Editor editor = sp.edit();
                    if(username_1.equals(ming) && passworld_1.equals(mi)){
                            editor.putString("username",username_1);
                            editor.putString("passworld",passworld_1);
                            editor.commit();
                            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this,"储存成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"账户或密码错误",Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }
    }
}