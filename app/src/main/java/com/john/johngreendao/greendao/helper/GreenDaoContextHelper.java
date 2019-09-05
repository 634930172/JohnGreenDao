package com.john.johngreendao.greendao.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;


import com.john.johngreendao.greendao.util.DBPathUtil;

import java.io.File;


/**
 * Author: John
 * E-mail：634930172@qq.com
 * Date: 2018/2/2 9:27
 * Description:设置数据库存储路径
 */

public class GreenDaoContextHelper extends ContextWrapper {

    private Context context;
    public GreenDaoContextHelper(Context context) {
        super(context);
        this.context = context;
    }

    /**
     *  数据库文件存储路径 /mnt/internal_sd/Android/data/com.john.testproject/cache/John_database/test-db
     */
    @Override
    public File getDatabasePath(String name) {
        File dbFile= DBPathUtil.getIndividualCacheDirectory(context,"John_database",name);
        if(dbFile!=null){
            return dbFile;
        }else {
            return super.getDatabasePath(name);
        }

    }


    /**
     * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
    }

    /**
     * Android 4.0会调用此方法获取数据库。
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
    }

}