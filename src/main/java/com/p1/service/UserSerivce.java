package com.p1.service;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.mapper.UserMapper;
import com.p1.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    ResultVO r0=new ResultVO(0,"成功",null);
    ResultVO r1=new ResultVO(1,"失败",null);
    public ResultVO getByUserId(int userId){
        User user =userMapper.selectByUserId(userId);

        ResultVO resultVO =new ResultVO(0,"成功",user);

        return resultVO;
    }

    public ResultVO changeUserName( int userId,String userName){
        if(userName.length()<2){
            return new ResultVO(1,"名称须大于2位",null);
        }else{
            int i =userMapper.updateUserName(userId,userName);
            if (i>0){
                return r0;
            }else {
                return  r1;
            }
        }



    }
    public ResultVO changeUserPwd(int userId,String userPwd){
        User user =userMapper.selectByUserId(userId);
        String md5Password = Md5Utils.getMd5(userPwd);
       if (userPwd.length()<4){
           return new ResultVO(1,"密码不能小于4位",null);
       }else if(user.getUserPwd().equals(md5Password)) {
           return new ResultVO(1, "密码不能相同", null);
       }else{
           try {
              userMapper.updateUserPwd(userId,md5Password);
               return r0;
           } catch (Exception e) {
               return  r1;
           }
//  int i =userMapper.updateUserName(userId,userName);
//            if (i>0){
//                return r0;
//            }else {
//                return  r1;
//            }

        }




    }

}
