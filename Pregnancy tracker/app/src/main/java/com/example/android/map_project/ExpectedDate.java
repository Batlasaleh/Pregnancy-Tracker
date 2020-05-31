package com.example.android.map_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import static com.example.android.map_project.DBHelper.KEY_DATE;
import static com.example.android.map_project.DBHelper.TABLE_USER;

public class ExpectedDate extends AppCompatActivity {

    private ImageButton info;
    private ImageButton home;
    private EditText expected;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expected_date);

        expected=findViewById(R.id.expected_editText);
        home=findViewById(R.id.homebuton);
        info=findViewById(R.id.infobuton);
        dbHelper=new DBHelper(this);
        expected.setEnabled(false);

        String name=SaveSharedPreference.getUserName(this);

        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT "+KEY_DATE+" FROM "+TABLE_USER+" WHERE username = ?",new String[]{name});
        String w;
        if (cursor.getCount()>0){
            final int e=cursor.getColumnIndex(KEY_DATE);
            while (cursor.moveToNext()) {
                w = cursor.getString(e);
                String time[]=w.split("/");
                for (int i=0;i<=time.length;i++){
                    int real=Integer.parseInt(time[1]);
                    int m=Integer.parseInt(time[1])-3;
                    switch (m){
                        case 0:
                            m=12;
                            break;
                        case -1:
                            m=11;
                            break;
                        case -2:
                            m=10;
                            break;
                    }
                    int d=Integer.parseInt(time[0])+7;
                    int y;
                    if (real>m){
                        y=Integer.parseInt(time[2])+1;
                    }
                    else
                        y=Integer.parseInt(time[2]);

                    expected.setText(d+"/"+m+"/"+y);
                }
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ExpectedDate.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ExpectedDate.this, Info.class);
                startActivity(intent);
            }
        });
    }
}
