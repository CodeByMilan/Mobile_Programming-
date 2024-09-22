package com.example.lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final int DB_version=2;
    private static final String DB_name="noteApp";

    public DBhelper(@Nullable Context context) {
        super(context, DB_name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE notes (_id INTEGER PRIMARY KEY AUTOINCREMENT,UUID VARCHAR(250),Title VARCHAR(250),Description VARCHAR(250))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query ="DROP TABLE IF EXISTS notes ";
        db.execSQL(query);
        onCreate(db);
    }
    public void InsertData(String uuid,String title,String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UUID",uuid);
        values.put("Title",title);
        values.put("Description",description);
        db.insert("notes",null,values);
        db.close();
    }
    public Cursor SelectData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM notes";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }
}
