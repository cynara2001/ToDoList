package com.example.todolist;

import android.os.Bundle;

import com.example.todolist.adapter.TodoListAdapter;
import com.example.todolist.db.ToDo;
import com.example.todolist.db.ToDoDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mToDoList;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initUI();
        //初始化数据
        initData();


    }

    private void initData() {
        ToDoDao toDoDao = ToDoDao.getInstance(getApplicationContext());
        List<ToDo> toDoList = toDoDao.findAll();
        TodoListAdapter adapter = new TodoListAdapter(getApplicationContext(),toDoList);
        mToDoList.setAdapter(adapter);
    }

    private void initUI() {
        mToDoList = findViewById(R.id.lv_todo_list);
        fab = findViewById(R.id.main_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder.create();
        View view = View.inflate(getApplicationContext(), R.layout.todo_dialog, null);
        alertDialog.setView(view);
        alertDialog.show();

        EditText etMContent = view.findViewById(R.id.dialog_et_mContent);
        EditText etBeginYear = view.findViewById(R.id.dialog_et_beginYear);
        EditText etBeginMonth = view.findViewById(R.id.dialog_et_beginMonth);
        EditText etBeginDay = view.findViewById(R.id.dialog_et_beginDay);
        EditText etOverYear = view.findViewById(R.id.dialog_et_overYear);
        EditText etOverMonth = view.findViewById(R.id.dialog_et_overMonth);
        EditText etOverDay = view.findViewById(R.id.dialog_et_overDay);

        view.findViewById(R.id.dialog_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mContent = etMContent.getText().toString();
                int beginYear = Integer.parseInt(etBeginYear.getText().toString());
                int beginMonth = Integer.parseInt(etBeginMonth.getText().toString());
                int beginDay = Integer.parseInt(etBeginDay.getText().toString());
                int overYear = Integer.parseInt(etOverYear.getText().toString());
                int overMonth = Integer.parseInt(etOverMonth.getText().toString());
                int overDay = Integer.parseInt(etOverDay.getText().toString());

                String fall1 = "请输入全部完整内容";
                String fall2 = "请输入正确的数据";

                //如果其中一个等于零的话，就不让它往下走
                if (mContent.length() == 0 || beginYear == 0 || beginMonth == 0 || beginDay == 0 || overYear == 0 || overMonth == 0 || overDay == 0) {
                    Toast.makeText(getApplicationContext(), fall1, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mContent.length() > 200 || beginYear > 3000 || beginMonth>12 || beginDay>31 || overYear> 3000 || overMonth>12 || overDay>31) {
                    Toast.makeText(getApplicationContext(), fall2, Toast.LENGTH_SHORT).show();
                    return;
                }

                //保存到数据库
                saveToDB(mContent, beginYear, beginMonth, beginDay, overYear, overMonth, overDay);

                alertDialog.dismiss();
            }

        });

        view.findViewById(R.id.dialog_btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void saveToDB(String mContent, int beginYear, int beginMonth, int beginDay, int overYear, int overMonth, int overDay) {
        ToDoDao toDoDao = ToDoDao.getInstance(getApplicationContext());
        ToDo toDo = new ToDo(mContent,beginYear,beginMonth,beginDay,overYear,overMonth,overDay);
        toDoDao.insert(toDo);

        initData();
    }



}