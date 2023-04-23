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
import java.util.Map;

@Service
public class UserWantService {
    @Autowired
    private UserWantMapper userWantMapper;
    @Autowired
    private  MovieMapper movieMapper;

    public ResultVO saveUW(UserWant userWant,Integer userId,Integer movieId) {



        List<UserWant> userWantList = userWantMapper.selectUWByUserId(userId) ;

        for(UserWant uw : userWantList){
            if(uw .equals(userWant)){
                return new ResultVO(1, "重复", null);
            }
        }
        userWantMapper.insertUW(userWant);
        try {
            movieMapper.upCA(movieId);
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

//    public ResultVO removeUW(int userId, int movieId) {
//        try {
//            if(userWantMapper.selectUWById(userId,movieId)!=null){
//                userWantMapper.deleteUW(userId, movieId);
//                return new ResultVO(0, "成功", null);
//            }else {
//                return new ResultVO(1, "重复", null);
//            }
//        } catch (Exception e) {
//            return new ResultVO(1, "失败", null);
//        }
//    }

    public ResultVO queryConcernMovie(UserWant userWant){
        UserWant userWant1 = userWantMapper.selectUWById(userWant.getUserId(), userWant.getMovieId());
        if (userWant1!=null) return new ResultVO(0,"数据存在",null);
        else return new ResultVO(1,"数据不存在",null);
    }

    public ResultVO updateUserMovieConcern(Map<String,Object> data){
        Integer movieId = (int)data.get("movieId");
        Integer userId = (int)data.get("userId");
        boolean isConcern = (boolean)data.get("isConcern");
        ResultVO resultVO =null;
        if (isConcern){
            //取消关注
            int i = userWantMapper.deleteUW(userId, movieId);
            if (i>0) {
                return new ResultVO(0, "取消关注成功", null);
            } else {
                return new ResultVO(1,"取消关注失败",null);
            }
        }else {
            //关注
            int i = userWantMapper.insertUW(new UserWant(userId, movieId));
            if (i>0) {
                return new ResultVO(0, "关注成功", null);
            } else {
                return new ResultVO(1,"关注失败",null);
            }
        }
    }
}
