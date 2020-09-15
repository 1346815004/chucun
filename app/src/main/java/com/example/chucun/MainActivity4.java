package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;
    EditText et1;
    TextView tv1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        et1 = findViewById(R.id.et1);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);

        dbOpenHelper = new DBOpenHelper(this,"db_dict",null,1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = et1.getText().toString();
                Cursor cursor = dbOpenHelper.getReadableDatabase().query("tb_dict",null,"word=?",new String[]{key},null,null,null);
                ArrayList<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
                while (cursor.moveToNext()){
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("word",cursor.getString(1));
                    map.put("interprct",cursor.getString(2));
                    resultList.add(map);
                }
                if (resultList == null || resultList.size() == 0){
                    Toast.makeText(MainActivity4.this,"没找到数据",Toast.LENGTH_SHORT);
                }else{
//                    SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity4.this,resultList,
//                            R.layout.activity_main4,
//                            new String[]{"word","interprct"},new int[]{R.id.result_word,R.id.result_interpret};
//                            );

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbOpenHelper!=null){
            dbOpenHelper.close();
        }
    }
}