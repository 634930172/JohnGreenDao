package com.john.johngreendao.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Author: John
 * E-mail：634930172@qq.com
 * Date: 2018/2/1 14:25
 * Description:用户数据库
 */
@Entity
public class User {
    @Id(autoincrement = true)//自增长
    private Long id;
    private String name;
    private int age;
    @Generated(hash = 586692638)
    public User() {
    }
    @Generated(hash = 1309193360)
    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
