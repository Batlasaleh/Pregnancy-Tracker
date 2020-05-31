package com.example.android.map_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.android.map_project.DBHelper.KEY_DATE;
import static com.example.android.map_project.DBHelper.KEY_IMAGE;
import static com.example.android.map_project.DBHelper.KEY_RECOMMEND;
import static com.example.android.map_project.DBHelper.KEY_SYMPTOM;
import static com.example.android.map_project.DBHelper.TABLE_MONTH;
import static com.example.android.map_project.DBHelper.TABLE_USER;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyMonth extends AppCompatActivity {

    private ImageButton info;
    private ImageButton home;
    private TextView recom;
    private TextView symp;
    private ImageView weight;
    private TextView m;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_month);

        home = findViewById(R.id.homebuton);
        info = findViewById(R.id.infobuton);
        recom = findViewById(R.id.recom);
        symp = findViewById(R.id.sp);
        weight = findViewById(R.id.monthweight);
        m= findViewById(R.id.month);

        Intent intent = getIntent();
        String month = intent.getStringExtra("month");
        m.setText("الشهر "+month);
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyMonth.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            });

            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyMonth.this, Info.class);
                    startActivity(intent);
                }
            });

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        String re=databaseAccess.recom(month);
        String s=databaseAccess.sy(month);
        recom.setText(re);
        symp.setText(s);
        weight.setImageBitmap(databaseAccess.getimage(month));
        databaseAccess.close();


        }

    }
