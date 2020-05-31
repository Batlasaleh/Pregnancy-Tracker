package com.example.android.map_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {
    public static final String DB_NAME="DB.db";
    public static final int DB_VERSION=1;
    //month table
    public static final String TABLE_MONTH="Months";
    public static final String KEY_MONTH="month";
    public static final String KEY_IMAGE="image";
    public static final String KEY_RECOMMEND="recomand";
    public static final String KEY_SYMPTOM="sym";

    //user table
    public static final String TABLE_USER="user";
    public static final String KEY_NAME="username";
    public static final String KEY_PASS="password";
    public static final String KEY_DATE="date";
    public static final String KEY_USER_MONTH="month";

    public DBHelper(Context context) {
        super(context, DB_NAME, null,null, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

}
