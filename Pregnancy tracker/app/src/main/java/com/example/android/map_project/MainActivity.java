package com.example.android.map_project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import static com.example.android.map_project.App.MONTHLY_NOTIFICATION;
import static com.example.android.map_project.DBHelper.KEY_DATE;
import static com.example.android.map_project.DBHelper.KEY_NAME;
import static com.example.android.map_project.DBHelper.TABLE_USER;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button myDate;
    private Button myMonth;
    private Button months;
    private ImageButton info;
    private ImageButton home;
    int m0, m1, m2, m3, m4, m5, m6, m7, m8, m9,real;
    int month,mDay;
    int d,y, year;
    DBHelper dbHelper;
    Calendar cc;
    private ImageView account;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (SaveSharedPreference.getUserName(this).length() == 0) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        } else {

            myDate = findViewById(R.id.myDate_button);
            myMonth = findViewById(R.id.myMonth_button);
            months = findViewById(R.id.months_button);
            home = findViewById(R.id.homebuton);
            info = findViewById(R.id.infobuton);
            account=findViewById(R.id.account);

            dbHelper=new DBHelper(this);
            name = SaveSharedPreference.getUserName(this);
            cc = Calendar.getInstance();
            year=cc.get(Calendar.YEAR);
            month=cc.get(Calendar.MONTH)+1;
            mDay = cc.get(Calendar.DAY_OF_MONTH);

            account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(MainActivity.this, v);
                    popup.setOnMenuItemClickListener(MainActivity.this);
                    popup.inflate(R.menu.menu_popup);
                    popup.show();

                }
            });




            SQLiteDatabase database = dbHelper.getReadableDatabase();
            Cursor cursor = database.rawQuery("SELECT " + KEY_DATE + " FROM " + TABLE_USER + " WHERE username = ?", new String[]{name});
            String w;
            if (cursor.getCount() > 0) {
                final int e = cursor.getColumnIndex(KEY_DATE);
                while (cursor.moveToNext()) {
                    w = cursor.getString(e);
                    String time[] = w.split("/");
                    for (int i = 0; i <= time.length; i++) {
                        d = Integer.parseInt(time[0]);
                        m0 = Integer.parseInt(time[1]);
                        real=Integer.parseInt(time[1]);
                        y = Integer.parseInt(time[2]);
                    }
                    m1 = m0 + 1;
                    m2 = m0 + 2;
                    m3 = m0 + 3;
                    m4 = m0 + 4;
                    m5 = m0 + 5;
                    m6 = m0 + 6;
                    m7 = m0 + 7;
                    m8 = m0 + 8;
                    m9 = m0 + 9;

                    switch (m1) {
                        case 13: m1 = 1;break;
                        case 14: m1 = 2;break;
                        case 15: m1 = 3;break;
                        case 16: m1 = 4;break;
                        case 17: m1 = 5;break;
                        case 18: m1 = 6;break;
                        case 19: m1 = 7;break;
                        case 20: m1 = 8;break;
                        case 21: m1 = 9;break;
                    }
                    switch (m2) {
                        case 13: m2 = 1;break;
                        case 14: m2 = 2;break;
                        case 15: m2 = 3;break;
                        case 16: m2 = 4;break;
                        case 17: m2 = 5;break;
                        case 18: m2 = 6;break;
                        case 19: m2 = 7;break;
                        case 20: m2 = 8;break;
                        case 21: m2 = 9;break;
                    }
                    switch (m3) {
                        case 13: m3 = 1;break;
                        case 14: m3 = 2;break;
                        case 15: m3 = 3;break;
                        case 16: m3 = 4;break;
                        case 17: m3 = 5;break;
                        case 18: m3 = 6;break;
                        case 19: m3 = 7;break;
                        case 20: m3 = 8;break;
                        case 21: m3 = 9;break;
                    }
                    switch (m4) {
                        case 13: m4 = 1;break;
                        case 14: m4 = 2;break;
                        case 15: m4 = 3;break;
                        case 16: m4 = 4;break;
                        case 17: m4 = 5;break;
                        case 18: m4 = 6;break;
                        case 19: m4 = 7;break;
                        case 20: m4 = 8;break;
                        case 21: m4 = 9;break;
                    }
                    switch (m5) {
                        case 13: m5 = 1;break;
                        case 14: m5 = 2;break;
                        case 15: m5 = 3;break;
                        case 16: m5 = 4;break;
                        case 17: m5 = 5;break;
                        case 18: m5 = 6;break;
                        case 19: m5 = 7;break;
                        case 20: m5 = 8;break;
                        case 21: m5 = 9;break;
                    }
                    switch (m6) {
                        case 13: m6 = 1;break;
                        case 14: m6 = 2;break;
                        case 15: m6 = 3;break;
                        case 16: m6 = 4;break;
                        case 17: m6 = 5;break;
                        case 18: m6 = 6;break;
                        case 19: m6 = 7;break;
                        case 20: m6 = 8;break;
                        case 21: m6 = 9;break;
                    }
                    switch (m7) {
                        case 13: m7 = 1;break;
                        case 14: m7 = 2;break;
                        case 15: m7 = 3;break;
                        case 16: m7 = 4;break;
                        case 17: m7 = 5;break;
                        case 18: m7 = 6;break;
                        case 19: m7 = 7;break;
                        case 20: m7 = 8;break;
                        case 21: m7 = 9;break;
                    }
                    switch (m8) {
                        case 13: m8 = 1;break;
                        case 14: m8 = 2;break;
                        case 15: m8 = 3;break;
                        case 16: m8 = 4;break;
                        case 17: m8 = 5;break;
                        case 18: m8 = 6;break;
                        case 19: m8 = 7;break;
                        case 20: m8 = 8;break;
                        case 21: m8 = 9;break;
                    }
                    switch (m9) {
                        case 13: m9 = 1;break;
                        case 14: m9 = 2;break;
                        case 15: m9 = 3;break;
                        case 16: m9 = 4;break;
                        case 17: m9 = 5;break;
                        case 18: m9 = 6;break;
                        case 19: m9 = 7;break;
                        case 20: m9 = 8;break;
                        case 21: m9 = 9;break;
                    }

                }
            }
            //myDate.setText(mDay+"-"+month+"-"+year);
            notification();

            myDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ExpectedDate.class);

                    startActivity(intent);
                }
            });

            myMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MyMonth.class);
                    if (mDay>=d && month==m0 || mDay<d && month==m1)
                        intent.putExtra("month","1");
                    if (mDay>=d && month==m1 || mDay<d && month==m2)
                        intent.putExtra("month","2");
                    if (mDay>=d && month==m2 || mDay<d && month==m3)
                        intent.putExtra("month","3");
                    if (mDay>=d && month==m3 || mDay<d && month==m4)
                        intent.putExtra("month","4");
                    if (mDay>=d && month==m4 || mDay<d && month==m5)
                        intent.putExtra("month","5");
                    if (mDay>=d && month==m5 || mDay<d && month==m6)
                        intent.putExtra("month","6");
                    if (mDay>=d && month==m6 || mDay<d && month==m7)
                        intent.putExtra("month","7");
                    if (mDay>=d && month==m7 || mDay<d && month==m8)
                        intent.putExtra("month","8");
                    if (mDay>=d && month==m8 || mDay<d && month==m9)
                        intent.putExtra("month","9");
                    if (mDay>=d && month==m9 || mDay<d && month==m9)
                        intent.putExtra("month","9");

                    startActivity(intent);
                }
            });

            months.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Months.class);
                    startActivity(intent);
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                }
            });

            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Info.class);
                    startActivity(intent);
                }
            });
        }
    }
    public void notification(){
        Intent notificationIntent = new Intent(this,MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,
                notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        if((mDay+"/"+month+"/"+year).equals(d+"/"+m1+"/"+year)){

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m2+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m3+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m4+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m5+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m6+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m7+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }
        if((mDay+"/"+month+"/"+year).equals(d+"/"+m8+"/"+year)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MONTHLY_NOTIFICATION)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("تهانينا!")
                    .setContentText("تهانينا! لقد دخلتي شهر جديد!")
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.birth))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent);
            NotificationManager Manager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            Manager.notify(1, builder.build());
        }

    }

    private void Dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("هل تريدين الحذف؟");
        dialog.setCancelable(false);
        dialog.setPositiveButton("نعم",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        DBHelper dbHelper = new DBHelper(getBaseContext());
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        long rowId = db.delete(TABLE_USER,KEY_NAME + "=?",new
                                String[]{name});
                        if(rowId>0) {
                            Toast.makeText(getBaseContext(), "تم الحذف بنجاح",
                                    Toast.LENGTH_LONG).show();
                            PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().apply();
                            Intent i = new Intent(MainActivity.this,Login.class);
                            startActivity(i);
                        }
                    }
                });
        dialog.setNegativeButton("لا",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_update:
                Intent intent = new Intent(MainActivity.this,Update_info.class);
                startActivity(intent);
                break;
            case R.id.action_delete:
                Dialog();
                break;
        }
        return true;

    }
}