package com.john.johngreendao.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Author: John
 * E-mail：634930172@qq.com
 * Date: 2018/2/1 16:09
 * Description:Customer数据库
 */
@Entity
public class Customer {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private int age;
    //新加字段
    private String sex;
    //新加字段
    private String like;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Transient
    private int tempUsageCount; // not persisted

    public Customer(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }
    @Generated(hash = 60841032)
    public Customer() {
    }
    @Generated(hash = 1675384187)
    public Customer(Long id, String name, int age, String sex, String like) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.like = like;
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
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
 
}
