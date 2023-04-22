package com.p1.service;

import com.p1.entity.ResultVO;


import com.p1.entity.User;
import com.p1.mapper.LoginMapper;
import com.p1.mapper.UserMapper;

import com.p1.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public ResultVO check(String account, String userPwd) {
        String pwd = null;

        //根据管理员id查询管理员信息
        User user = loginMapper.selectByac(account);
        pwd = user == null ? null : user.getUserPwd();

        if (pwd == null) {// 账号为空时，密码为空。查询失败
            return new ResultVO(1, "账号错误", null);
        } else {
            /*
            密码不为空，表示查到信息
            * */
            //对输入密码进行加密
            userPwd = Md5Utils.getMd5(userPwd);
            if (userPwd.equals(pwd)) {
                return new ResultVO(0, "登陆成功", null);
            } else {
                return new ResultVO(1, "密码错误", null);
            }

        }

    }
}
