package com.p1.mapper;

import com.p1.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    public int insertMovie(Movie movie);

    public List<Movie> selectMovieList();

    public int selectCount();

    public Movie selectByName(String movieName);
   // public int  selectScoreCount(String movieName);
    public int scoring(@Param("movieName") String movieName,@Param("movieScore") double movieScore);

    List<Movie> getAllMovieBaseInfo();
    Movie queryMovieInfoById(@Param("id") Integer id);

}
