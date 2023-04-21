package com.p1.utils;

import org.springframework.util.DigestUtils;

public class Md5Utils {
     public static String getMd5(String password){
         //MD5加密
         return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
