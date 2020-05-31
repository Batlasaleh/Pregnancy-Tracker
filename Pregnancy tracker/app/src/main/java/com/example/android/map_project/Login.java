package com.example.android.map_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.android.map_project.DBHelper.TABLE_USER;

public class Login extends AppCompatActivity {

    private TextView register;
    private Button login;
    private EditText username;
    private EditText password;
    DBHelper dbHelper;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper=new DBHelper(this);
        register=findViewById(R.id.register);
        login=findViewById(R.id.button);
        username=findViewById(R.id.name_editText);
        password=findViewById(R.id.pass_editText);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=username.getText().toString();
                String pass=password.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)){
                    //something empty
                    Toast.makeText(Login.this,"الرجاء تعبئة جميع الفراغات!",Toast.LENGTH_SHORT).show();
                    //stop the function
                    return;
                }
                //if ok
                SQLiteDatabase database=dbHelper.getReadableDatabase();
                Cursor cursor = database.rawQuery("SELECT * FROM "+TABLE_USER+" WHERE username=? and password=?",new String[]{name,pass});
                if (cursor.getCount()>0){
                    gotomain();
                }

                else
                    Toast.makeText(Login.this,"الرجاء التأكد من الاسم/كلمة السر!",Toast.LENGTH_LONG).show();


            }
        });
    }
    public void gotomain(){
        Intent intent=new Intent(this, MainActivity.class);
        SaveSharedPreference.setUserName(this,name);
        startActivity(intent);
    }

}

