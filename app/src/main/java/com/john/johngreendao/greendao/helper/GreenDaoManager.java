package com.john.johngreendao.greendao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.john.johngreendao.greendao.dao.DaoMaster;
import com.john.johngreendao.greendao.dao.DaoSession;


/**
 * Author: John
 * E-mail：634930172@qq.com
 * Date: 2018/2/1 16:04
 * Description:GreenDao管理类
 */

public class GreenDaoManager {

    private static SQLiteDatabase db;
    private static DaoSession mDaoSession;

    /**
     * 初始化greenDao
     */
    public static void initDatabase(Context context) {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        //最基本DaoMaster.DevOpenHelper使用 开发阶段时用
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(context, "test-db", null);
        //自定义数据库版本控制 上线的时候用 将上面注销掉
        //        GreenDaoOpenHelper mHelper = new GreenDaoOpenHelper(new GreenDaoContextHelper(context), "test-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

}