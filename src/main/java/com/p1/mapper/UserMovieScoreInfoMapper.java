package com.p1.mapper;

import com.p1.entity.UserMovieScore;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMovieScoreInfoMapper {
    UserMovieScore queryUserScoreMovie(@Param("userId")Integer userId, @Param("movieId")Integer movieId);
    int insertUserMovieScore(@Param("userMovieScore") UserMovieScore userMovieScore);
    int updateUserMovieScore(@Param("userMovieScore") UserMovieScore userMovieScore);
}
