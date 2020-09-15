package com.example.chucun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    private String s1 = ContactsContract.Contacts.DISPLAY_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(getQueryData());
            }
        });

    }

    private CharSequence getQueryData(){
        StringBuilder stringBuilder = new StringBuilder();
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        int displayNameIndex = cursor.getColumnIndex(s1);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            String name = cursor.getString(displayNameIndex);
            stringBuilder.append(name+"\n");
        }
        cursor.close();
        return stringBuilder.toString();
    }
}