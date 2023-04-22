package com.p1.service;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.mapper.UserMapper;
import com.p1.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivce {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user
     * @return
     */
    public ResultVO saveUser(User user){
        try {
            String md5Password = Md5Utils.getMd5(user.getUserPwd());
            user.setUserPwd(md5Password);
            userMapper.insertUser(user);
            return new ResultVO(0,"注册成功",null);
        } catch (Exception e) {
            return new ResultVO(1,"账号重复",null);
        }

//        if(i>0){
//            return new ResultVO(0,"注册成功",null);
//        }else {
//            return new ResultVO(1,"注册失败",null);
//        }
    }

}
