package com.john.johngreendao.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Author: John
 * E-mail: 634930172@qq.com
 * Date: 2018/7/15 23:42
 * <p/>
 * Description:
 */
@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String age;

    @Generated(hash = 563965806)
    public Student(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
