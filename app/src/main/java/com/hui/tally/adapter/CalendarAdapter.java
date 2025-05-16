package com.hui.tally.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.hui.tally.R;

import java.util.ArrayList;
import java.util.List;

/*
* 历史账单界面，点击日历表，弹出对话框，当中的GridView对应的适配器
* 用于Android应用中历史账单界面的日历对话框的适配器类 CalendarAdapter，
* 继承自 BaseAdapter。它的主要功能是为一个GridView提供月份数据（如"2023/1", "2023/2"等），
* 并支持选中某个月份时高亮显示。
* */
public class CalendarAdapter extends BaseAdapter {
    Context context;
    List<String>mDatas;
    public int year;
    public int selPos = -1;

    public void setYear(int year) {
        this.year = year;
        mDatas.clear();
        loadDatas(year);
        notifyDataSetChanged();
    }

    public CalendarAdapter(Context context, int year) {
        this.context = context;
        this.year = year;
        mDatas = new ArrayList<>();
        loadDatas(year);
    }

    private void loadDatas(int year) {
        for (int i = 1; i < 13; i++) {
            String data = year+"/"+i;
            mDatas.add(data);
        }
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_dialogcal_gv,parent,false);
        TextView tv = convertView.findViewById(R.id.item_dialogcal_gv_tv);
        tv.setText(mDatas.get(position));
        tv.setBackgroundResource(R.color.grey_f3f3f3);
        tv.setTextColor(Color.BLACK);
        if (position == selPos) {
            tv.setBackgroundResource(R.color.green_006400);
            tv.setTextColor(Color.WHITE);
        }
        return convertView;
    }
}
