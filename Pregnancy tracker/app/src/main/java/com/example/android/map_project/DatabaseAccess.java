package com.example.android.map_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.time.Month;
import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;
    //Cursor c=null;

    //private constructor
    private DatabaseAccess(Context context){
        this.openHelper=new DBHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=this.openHelper.getWritableDatabase();
    }

    public void close(){
        if (this.db!=null){
            this.db.close();
        }
    }

    public String recom(String month){
        Cursor c1=db.rawQuery("SELECT recomand FROM Months WHERE month = '"+month+"'",new String[]{});
        StringBuffer buffer=new StringBuffer();
        while (c1.moveToNext()){
            String recom=c1.getString(0);
            buffer.append(""+recom);
        }
        return buffer.toString();
    }
    public String sy(String month){
        Cursor c2=db.rawQuery("SELECT sym FROM Months WHERE month = '"+month+"'",new String[]{});
        StringBuffer buffer=new StringBuffer();
        while (c2.moveToNext()){
            String sym=c2.getString(0);
            buffer.append(""+sym);
        }
        return buffer.toString();
    }
    public Bitmap getimage(String month) {
        Bitmap bt = null;
        Cursor c3 = db.rawQuery("SELECT image FROM Months WHERE month = '" + month + "'", new String[]{});
        while (c3.moveToNext()) {
            byte[] img = c3.getBlob(0);
            bt = BitmapFactory.decodeByteArray(img, 0, img.length);
        }
        return bt;
    }

}
