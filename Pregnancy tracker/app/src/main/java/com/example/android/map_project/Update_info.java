package com.example.android.map_project;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import static com.example.android.map_project.DBHelper.KEY_DATE;
import static com.example.android.map_project.DBHelper.KEY_NAME;
import static com.example.android.map_project.DBHelper.KEY_PASS;
import static com.example.android.map_project.DBHelper.KEY_USER_MONTH;
import static com.example.android.map_project.DBHelper.TABLE_USER;

public class Update_info extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText period;
    EditText name;
    EditText pass;
    EditText month;
    Button update;
    Button cancel;
    String date;
    String mon,day,year;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        name = findViewById(R.id.name_editText);
        pass = findViewById(R.id.pass_editText);
        month = findViewById(R.id.monthnow_editText3);
        period = findViewById(R.id.lastperiod_editText);
        update = findViewById(R.id.ubdate_button);
        cancel = findViewById(R.id.cancel_button);


        name.setEnabled(false);
        uname=SaveSharedPreference.getUserName(this);
        name.setText(uname);

        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        DBHelper dbHelper= new DBHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER,new String[] {"*"}, KEY_NAME+"=?",
                new String[]{uname},null,null,null);
        cursor.moveToNext();
        String p=cursor.getString(cursor.getColumnIndex(KEY_PASS));
        String d=cursor.getString(cursor.getColumnIndex(KEY_DATE));
        String m=cursor.getString(cursor.getColumnIndex(KEY_USER_MONTH));
        pass.setText(p);
        period.setText(d);
        month.setText(m);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper= new DBHelper(getBaseContext());
                SQLiteDatabase database=dbHelper.getWritableDatabase();

                String password= pass.getText().toString();
                date=period.getText().toString();
                String m=month.getText().toString();

                String d[]=date.split("/");
                for (int i=0;i<=date.length();i++){
                    mon=d[0];
                    day=d[1];
                    year="20"+d[2];
                }
                ContentValues cv=new ContentValues();
                cv.put(KEY_PASS, password);
                cv.put(KEY_DATE, day+"/"+mon+"/"+year);
                cv.put(KEY_USER_MONTH,m);

                long update=database.update(TABLE_USER,cv,KEY_NAME+"=?",new String[]{uname});

                if (TextUtils.isEmpty(password)||TextUtils.isEmpty(date)||TextUtils.isEmpty(m)){
                    //something empty
                    Toast.makeText(Update_info.this,"الرجاء تعبئة جميع الفراغات!",Toast.LENGTH_SHORT).show();
                    //stop the function
                    return;
                }
                //if ok

                if (update>0){
                    Dialog();
                }
                else {
                    Toast.makeText(Update_info.this, "هناك شسئا خاطئ!", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Update_info.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("تم التحديث بنجاح!");
        dialog.setCancelable(false);
        dialog.setPositiveButton("اذهب",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent intent=new Intent(Update_info.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());

        period.setText(currentDateString);
    }


}
