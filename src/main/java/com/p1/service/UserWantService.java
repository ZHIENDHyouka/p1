package com.p1.service;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.entity.UserWant;
import com.p1.mapper.MovieMapper;
import com.p1.mapper.UserWantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWantService {

    @Autowired
    private UserWantMapper userWantMapper;
    @Autowired
    private  MovieMapper movieMapper;

    public ResultVO saveUW(UserWant userWant,Integer userId,Integer movieId) {
        Movie movie = movieMapper.selectById(movieId);
       // movie.setSocreCount(movie.getSocreCount()+1);
//电影关注数添加功能有问题
        List<UserWant> userWantList = userWantMapper.selectUWByUserId(userId) ;


        for(UserWant uw : userWantList){
            if(uw .equals(userWant)){
                return new ResultVO(1, "重复", null);
            }
        }
        userWantMapper.insertUW(userWant);
        try {

            return new ResultVO(0, "成功", null);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }

    public ResultVO searchUW(Integer userId) {
        List<UserWant> userWantList = userWantMapper.selectUWByUserId(userId);
       // Integer count = userWantMapper.selectCount();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + userWantList.size() + "个关注", userWantList);
        return resultVO;


    }

    public ResultVO removeUW(int userId, int movieId) {
        try {
            if(userWantMapper.selectUWById(userId,movieId)!=null){
                userWantMapper.deleteUW(userId, movieId);
                return new ResultVO(0, "成功", null);
            }else {
                return new ResultVO(1, "重复", null);
            }

        } catch (Exception e) {
            return new ResultVO(1, "失败", null);

        }
    }
}
