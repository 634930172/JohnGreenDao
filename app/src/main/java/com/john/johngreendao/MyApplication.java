package com.john.johngreendao;

import android.app.Application;

import com.john.johngreendao.greendao.helper.GreenDaoManager;


/**
 * Author: John
 * E-mail: 634930172@qq.com
 * Date: 2018/7/17 10:30
 * <p/>
 * Description:应用程序入口
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化GreenDao
        GreenDaoManager.initDatabase(this);
    }
}
