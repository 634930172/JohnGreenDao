package com.john.johngreendao.greendao.util;


import com.john.johngreendao.greendao.entity.User;

import java.lang.reflect.Field;

/**
 * Author: John test的提交  test1 test2 test3 test4 test5 test6
 * E-mail: 634930172@qq.com
 * Date: 2018/7/17 11:03
 * <p/>
 * Description:反射工具类 为了便于展示数据
 */
public class ReflectUtil {

    private static final String TAG = "ReflectUtil";

    public static String getDataText(User user) {
        Class<? extends User> aClass = user.getClass();
        StringBuilder builder = new StringBuilder();
        Field[] declaredFields = aClass.getDeclaredFields();//获取到该类的所有属性
        for (Field file : declaredFields) {
            try {
                if (!file.isAccessible()) {
                    file.setAccessible(true);
                }
                Object value = file.get(user);//获取属性值
                String key = file.getName();//获取属性名
                //greenDao编译会生成的属性 屏蔽掉
                if(!key.startsWith("$change")&&!key.startsWith("serialVersionUID")){
                    builder.append(key).append(" : ").append(value).append(";");//属性值+属性名
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
