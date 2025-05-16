package com.hui.tally;

import android.app.Application;

import com.hui.tally.db.DBManager;

/* 表示全局应用的类*/
public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化数据库
        DBManager.initDB(getApplicationContext());
    }
}
//全局应用的类 UniteApp，它继承自 Android 的 Application 类，
// 主要用于 应用级别的初始化操作，特别是 数据库的初始化。