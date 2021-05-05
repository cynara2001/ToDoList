package com.example.todolist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责管理数据库的类
 * 主要对于表当中的内容进行操作，增删改查
 */

public class ToDoDao {
    private final ToDoOpenHelper toDoOpenHelper;

    private static ToDoDao toDoDao = null;

    /**
     * 这是一个私有的构造方法
     *
     * @param context
     */
    private ToDoDao(Context context) {
        toDoOpenHelper = new ToDoOpenHelper(context);
    }

    public static ToDoDao getInstance(Context context) {
        if (toDoDao == null) {
            toDoDao = new ToDoDao(context);
        }
        return toDoDao;
    }

    //保存数据
    public void insert(ToDo toDo) {
        //我们使用toDoOpenHelper获取一个可写的数据库实例

        //实例化数据库对象
        SQLiteDatabase database = toDoOpenHelper.getWritableDatabase();

        //构造保存数据
        ContentValues values = new ContentValues();

        values.put("mContent", toDo.getMContent());
        values.put("beginYear", toDo.getBeginYear());
        values.put("beginMonth", toDo.getBeginMonth());
        values.put("beginDay", toDo.getBeginDay());
        values.put("overYear", toDo.getOverYear());
        values.put("overMonth", toDo.getOverMonth());
        values.put("overDay", toDo.getOverDay());

        //插入数据
        database.insert("toDo", null, values);

        //关闭数据库
        database.close();
    }


    public List<ToDo> findAll() {
        //实例化数据库对象
        SQLiteDatabase database = toDoOpenHelper.getWritableDatabase();

        Cursor cursor = database.query("toDo", new String[]{"_id","mContent","beginYear","beginMonth","beginDay","overYear","overMonth","overDay"}, null, null, null, null, null);

        List<ToDo> toDoList = new ArrayList<>();

        while (cursor.moveToNext()) {
            ToDo toDo = new ToDo();
            toDo.setId(cursor.getInt(0));
            //第0是id，第1是……，第2是……
            toDo.setMContent(cursor.getString(1));
            toDo.setBeginYear(cursor.getInt(2));
            toDo.setBeginMonth(cursor.getInt(3));
            toDo.setBeginDay(cursor.getInt(4));
            toDo.setOverYear(cursor.getInt(5));
            toDo.setOverMonth(cursor.getInt(6));
            toDo.setOverDay(cursor.getInt(7));

            toDoList.add(toDo);
        }

        //关闭数据库
        database.close();

        return toDoList;


    }
}
