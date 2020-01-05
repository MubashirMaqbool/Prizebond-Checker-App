package com.dsa.shaheenpc.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase  extends SQLiteOpenHelper {
    public static final String DataBase_Name="PrizeBond.db";
    public static final  String Table_Name="search_numbers";
    public static final  String Col_1="ID";
    public static final  String Col_2="Name";
  //  public static final  String Col_3="Marks";


//Mubashir MAqbool UEt taxila
    public DataBase(Context context) {
        super(context, DataBase_Name,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
        onCreate(db);
    }
    public boolean InserData(String numbers){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,numbers);
        //contentValues.put(Col_3,marks);
        long l=db.insert(Table_Name,null,contentValues);
        if(l==-1){
            return false;
        }
        else
            return true;


    }
    public Cursor ShowData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+Table_Name,null);
        return cursor;

    }
    public Integer DelData(String number){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(Table_Name,"NAME = ?",new String[]{number});

    }
}
