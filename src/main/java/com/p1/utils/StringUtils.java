package com.p1.utils;

import com.p1.entity.User;

import java.lang.reflect.Field;

public class StringUtils {
    private static  String TARNAME = "java.lang.String";
    /**
     * 去除字符中空格
     * @param string
     * @return
     */
    public static String stringFormat(String string) {
        return string.replace(" ", "");
    }

    /**
     * 判断字符串是否为空 或者 长度为0
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        if (string != null) {
            string = stringFormat(string);
            return !(string.length() == 0);
        }
        return false;
    }

    /**
     * 将封装对象里面所有字符串类型格式化
     * @param o
     * @param <T>
     * @return
     */
    public static <T> T formatObjString(T o){
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields(); //获取类所有属性数组
        try {
            for (int i = 0; i < fields.length; i++) {
                String typeName = fields[i].getType().getTypeName(); //获取当前属性类型名称
                fields[i].setAccessible(true); //开启权限
                if (TARNAME.equals(typeName)&&fields[i].get(o)!=null) {
                    fields[i].set(o, StringUtils.stringFormat(fields[i].get(o).toString())); //格式化
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
