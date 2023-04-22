package com.p1.mapper;

import com.p1.entity.UserWant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserWantMapper {
    public int insertUW(UserWant userWant);

    public List<UserWant> selectUW(Integer userId);

    public int deleteUW(Integer userId, int movieId);

    public int selectCount();

    public UserWant selectUWById(Integer userId, int movieId);

    public List<UserWant> selectUWByUserId(Integer userId);//查询所有关注

}
