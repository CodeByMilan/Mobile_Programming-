package com.example.crudoperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class StudentDBHelper extends SQLiteOpenHelper {
    private final static String DB_Name="BCA";
    private final static int DB_Version =2;

    public StudentDBHelper(Context context){

        super(context,DB_Name,null,DB_Version);
    }
    public void onCreate(SQLiteDatabase db ){
        String query = "CREATE TABLE STUDENTS (ID STRING PRIMARY KEY ,NAME VARCHAR(200),ADDRESS VARCHAR(200))";
        db.execSQL(query);

    }
    public void onUpgrade(SQLiteDatabase db , int oldversion ,int newversion){
        String query ="DROP TABLE IF EXISTS STUDENTS ";
        db.execSQL(query);
        onCreate(db);
    }


    public void InsertData(String id ,String name,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID",id);
        values.put("NAME",name);
        values.put("ADDRESS",address);
        db.insert("STUDENTS",null,values);
        db.close();
    }
    public Cursor SelectData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM STUDENTS";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;

    }
    public void UpdateData(String id , String name , String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("NAME",name);
        values.put("ADDRESS",address);
        db.update("STUDENTS",values,"id=?",new String[]{id});
        db.close();
    }
    public void DeleteData(String id ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("STUDENTS","id=?",new String[]{id});
        db.close();

    }
}
