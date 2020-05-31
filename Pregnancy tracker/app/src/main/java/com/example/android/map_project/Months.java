package com.example.android.map_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Months extends AppCompatActivity {

    private ImageButton info;
    private ImageButton home;
    private CardView m1, m2, m3, m4, m5, m6, m7, m8, m9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);

        home=findViewById(R.id.homebuton);
        info=findViewById(R.id.infobuton);
        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);
        m6=findViewById(R.id.m6);
        m7=findViewById(R.id.m7);
        m8=findViewById(R.id.m8);
        m9=findViewById(R.id.m9);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this, Info.class);
                startActivity(intent);
            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "1");
                startActivity(intent);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "2");
                startActivity(intent);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "3");
                startActivity(intent);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "4");
                startActivity(intent);
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "5");
                startActivity(intent);
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "6");
                startActivity(intent);
            }
        });

        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "7");
                startActivity(intent);
            }
        });

        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "8");
                startActivity(intent);
            }
        });

        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Months.this,MyMonth.class);
                intent.putExtra("month", "9");
                startActivity(intent);
            }
        });

    }
}
