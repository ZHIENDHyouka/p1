package com.p1.mapper;

import com.p1.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    public int insertMovie(Movie movie);

    public List<Movie> selectMovieOSList();
    public List<Movie> selectMovieRSList();
    public List<Movie> selectMovieNSList();

    public int selectCount();

    public Movie selectByName(String movieName);
    public Movie selectById(Integer movieId);
   // public int  selectScoreCount(String movieName);
    public int scoring(@Param("movieName") String movieName,@Param("movieScore") double movieScore);
    public int upCA(Integer movieId);
    public void OnSale(Integer movieId);
    public void NotSale(Integer movieId);
    public int selectSale(Integer movieId);
    List<Movie> getAllMovieBaseInfo();
    Movie queryMovieInfoById(@Param("id") Integer id);

}
