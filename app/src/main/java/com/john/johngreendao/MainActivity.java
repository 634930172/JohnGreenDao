package com.john.johngreendao;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.john.johngreendao.greendao.dao.UserDao;
import com.john.johngreendao.greendao.entity.User;
import com.john.johngreendao.greendao.helper.GreenDaoManager;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.add)
    Button add;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.upload)
    Button upload;
    @BindView(R.id.listView)
    ListView listView;

    private MyAdapter adapter;
    private UserDao userDao;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        userDao = GreenDaoManager.getDaoSession().getUserDao();
        for (int i = 0; i <= 4; i++) {//默认先添加5条数据 下次再进入APP后又会增加5条 只是为了演示 可以注释掉
            User user1 = new User();
            user1.setName("小力");
            user1.setAge(18);
            userDao.insert(user1);
        }
        List<User> users = userDao.loadAll();
        adapter = new MyAdapter(this, users);
        listView.setAdapter(adapter);
    }


    @OnClick({R.id.add, R.id.delete, R.id.update, R.id.query, R.id.upload})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add://增
                // id自增 全部name为小力 age为25
                User user1 = new User();
                user1.setName(age % 2 == 0 ? "小力" : "大力");
                user1.setAge(age);
                userDao.insert(user1);
                queryUserData();//刷新数据
                age++;
                break;
            case R.id.delete://删
                //删除姓名为小力的所有user
                Query<User> queryUsers = userDao.queryBuilder().where(UserDao.Properties.Name.eq("小力")).build();
                if (queryUsers == null) {
                    return;
                }
                for (User user : queryUsers.list()) {
                    userDao.delete(user);
                }
                queryUserData();//刷新数据
                break;
            case R.id.update://改
                // 将ID为5的user改为name 大力力 age改为11  注意是否有ID=5 没有的话就没有效果了
                //                User queryUser = userDao.queryBuilder().where(UserDao.Properties.Id.eq(5)).build().unique();
                //                queryUser.setName("大大大力力");
                //                queryUser.setAge(11);
                //                userDao.update(queryUser);
                //将name为 小力 的User 改为大力力 age改为 11
                Query<User> queryUser = userDao.queryBuilder().where(UserDao.Properties.Name.eq("大力")).build();
                for (User user : queryUser.list()) {
                    user.setName("大大力力");
                    user.setAge(11);
                    userDao.update(user);
                }
                queryUserData();//刷新数据
                break;
            case R.id.query://查
                queryUserData();//刷新数据
                break;
            case R.id.upload://更新
                //------上线后数据库的更新步骤------
                //1.将GreenDaoManager中DaoMaster.DevOpenHelper注释掉，将GreenDaoOpenHelper注释打开；
                //2.修改表结构后让表都具有set和get方法；
                //3.如果有新增加的表，将表的类名加到GreenDaoOpenHelper的onUpgrade方法中的MigrationHelper.migrate方法中
                //4.将app下build.gradle目录中greendao的schemaVersion版本号+1；
                //5.make工程。
                break;
        }
    }

    /**
     * 查询整张表
     */
    public void queryUserData() {
        List<User> users = userDao.loadAll();//查询整张表
        adapter.refreshData(users);//刷新数据
    }

}
