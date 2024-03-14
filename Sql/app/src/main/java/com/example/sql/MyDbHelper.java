package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DBName="mydb.db";
    private static final int  VERSION=1;
    private static final String TABLENAME="SinhVien";
    private  static  String Id="_id";
    private static String Name="name";
    private static  String YEAROB="yearob";
    private SQLiteDatabase myDB;

    public MyDbHelper(@Nullable Context context) {
        super(context, DBName,null, VERSION);

    }

    public static String getId() {
        return Id;
    }

    public static String getName() {
        return Name;
    }

    public static String getYEAROB() {
        return YEAROB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable="CREATE TABLE "+ TABLENAME+
                "( "+ Id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Name+" TEXT NOT NULL, "+
                YEAROB+" INTEGER NOT NULL "+")";
        db.execSQL(queryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDb(){
        myDB= getWritableDatabase();
    }
    public void closeDb(){
        if(myDB !=null && myDB.isOpen()){
            myDB.close();
        }
    }
    // insert
    public long Insert(String name, int yearOb){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Name,name);
        values.put(YEAROB,yearOb);
        return db.insert(TABLENAME,null,values);
    }
    public Cursor DisplayAll(){
        String query="Select * from "+ TABLENAME;
        return  myDB.rawQuery(query,null);
    }
    public long Update(int id,String name,int yearOb){
        ContentValues values=new ContentValues();
        values.put(Id,id);
        values.put(Name,name);
        values.put(YEAROB,yearOb);
        String where=Id+" = "+id;
        return  myDB.update(TABLENAME,values,where,null);
    }
    public long Delete(int id){
        String where=Id+ " = "+ id;
        return  myDB.delete(TABLENAME,where,null);
    }
}
