package com.example.attendancemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname = "mydb";
    private static final int version = 1;

    public  MyHelper(Context context){
        super(context,dbname,null,version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS STUDENTS_DETAILS (ID INTEGER PRIMARY KEY AUTOINCREMENT, SUB_NAME TEXT ,CLASS_ATTENDED INT ,TOTAL_CLASSES INT)");

    }

    public boolean insertData(String subject, String  class_attended, String total_classes){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("SUB_NAME",subject);
        values.put("CLASS_ATTENDED",class_attended);
        values.put("TOTAL_CLASSES",total_classes);
        long result =database.insert("STUDENTS_DETAILS",null,values);
        if(result == -1) return  false;
        else return true;
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM STUDENTS_DETAILS",null);
        return cursor;
    }

    public boolean onUpdate(String id,String subject, String  class_attended, String total_classes){
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("ID",id);
        values.put("SUB_NAME",subject);
        values.put("CLASS_ATTENDED",class_attended);
        values.put("TOTAL_CLASSES",total_classes);
        database.update("STUDENTS_NAME",values,"ID=?",new String[]{id});
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
