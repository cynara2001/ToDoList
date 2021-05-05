package com.example.todolist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.db.ToDo;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {

    private final Context context;
    private final List<ToDo> toDoList;

    public TodoListAdapter(Context context, List<ToDo> toDoList) {
        this.context = context;
        this.toDoList = toDoList;
    }

    @Override
    public int getCount() {
        return toDoList.size();
    }

    @Override
    public Object getItem(int position) {
        return toDoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return toDoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.todo_item, null);
        }

        TextView tvMContent = convertView.findViewById(R.id.item_tv_mContent);
        TextView tvBeginYear = convertView.findViewById(R.id.item_tv_beginYear);
        TextView tvBeginMonth = convertView.findViewById(R.id.item_tv_beginMonth);
        TextView tvBeginDay = convertView.findViewById(R.id.item_tv_beginDay);
        TextView tvOverYear = convertView.findViewById(R.id.item_tv_overYear);
        TextView tvOverMonth = convertView.findViewById(R.id.item_tv_overMonth);
        TextView tvOverDay = convertView.findViewById(R.id.item_tv_overDay);

        tvMContent.setText(toDoList.get(position).getMContent());
        tvBeginYear.setText(toDoList.get(position).getBeginYear() + "");
        tvBeginMonth.setText(toDoList.get(position).getBeginMonth() + "");
        tvBeginDay.setText(toDoList.get(position).getBeginDay() + "");
        tvOverYear.setText(toDoList.get(position).getOverYear() + "");
        tvOverMonth.setText(toDoList.get(position).getOverMonth() + "");
        tvOverDay.setText(toDoList.get(position).getOverDay()+ "");

        return convertView;
    }
}
