package com.p1.service;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.entity.UserWant;
import com.p1.mapper.UserWantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWantService {
    int  count =0;
    @Autowired
    private UserWantMapper userWantMapper;

    public ResultVO saveUW(UserWant userWant,Integer userId) {

        List<UserWant> userWantList = userWantMapper.selectUWByUserId(userId) ;
        for(UserWant uw : userWantList){
            if(uw .equals(userWant)){
                return new ResultVO(1, "重复", null);
            }
        }
        userWantMapper.insertUW(userWant);
        try {
            count++;
            return new ResultVO(0, "成功", null);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }

    public ResultVO searchUW(Integer userId) {
        List<UserWant> userWantList = userWantMapper.selectUW(userId);
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + count + "个关注", userWantList);
        return resultVO;


    }

    public ResultVO removeUW(int userId, int movieId) {
        try {
            userWantMapper.deleteUW(userId, movieId);
            return new ResultVO(0, "成功", null);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }
    }
}
