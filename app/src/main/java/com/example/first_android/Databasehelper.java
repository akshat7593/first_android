package com.example.first_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String Database_name = "Student.db";
    public static final String Table_name = "student_table";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "NAME";
    //public static final String Col_3 = "LNAME";
    //p/ublic static final String Col_4 = "MARKS";

    public Databasehelper(Context context) {
        super(context,Database_name,null,1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name );
        onCreate(db);
    }

    public boolean insertdata(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(Col_2,name);
        long result = db.insert(Table_name,null,content);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_name,null);
        return res;
    }
}
