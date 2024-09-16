package com.example.chapter7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDBHelper extends SQLiteOpenHelper {
    private static final String DB_name ="students";
    private static final int DB_version=1;

    public StudentDBHelper(@Nullable Context context) {
        super(context, DB_name,null, DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students (_id INTEGER PRIMARY KEY ,email VARCHAR(250),name VARCHAR(250))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);

    }
}
