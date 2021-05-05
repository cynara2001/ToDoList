package com.example.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;


public class ToDoOpenHelper extends SQLiteOpenHelper {
    public ToDoOpenHelper(Context context) {
        super(context, "toDo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table toDo(_id integer primary key autoincrement,mContent varchar(50),beginYear int(20),beginMonth int(20),beginDay int(20),overYear int(20),overMonth int(20),overDay int(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
