package com.p1.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
    private Integer  userId;//用户id
    private String  userName;//   用户名
    private String userPwd;//密码
    private String userAccount;//账号（登录用）
    private Integer userVipLevel;// vip等级
    private Integer userSex;//1是男 0是女












}
