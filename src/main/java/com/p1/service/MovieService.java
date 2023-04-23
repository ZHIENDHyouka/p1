package com.p1.service;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    double sc=0.0;
    int co=0;
    @Autowired
    private MovieMapper movieMapper;

    public ResultVO addMovie(Movie movie) {
        try {
            movieMapper.insertMovie(movie);
            return new ResultVO(0, "添加电影成功", null);
        } catch (Exception e) {
            return new ResultVO(1, "添加电影失败", null);
        }
    }

    public ResultVO  getMovieOnSale() {
        List<Movie> movieList = movieMapper.selectMovieOSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影正在热映", movieList);
        return resultVO;
    }
    public ResultVO  getMovieReadySale() {
        List<Movie> movieList = movieMapper.selectMovieRSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影即将上映", movieList);
        return resultVO;
    }
    public ResultVO  getMovieNotSale() {
        List<Movie> movieList = movieMapper.selectMovieNSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影已经下架", movieList);
        return resultVO;
    }

    public ResultVO getByName(String movieName) {
        Movie movie = movieMapper.selectByName(movieName);
        ResultVO resultVO = new ResultVO(0, "成功",movie);
        return resultVO;
    }
//    public ResultVO getScore(String movieName,double movieScore){
//
//        try {
//            movieMapper.s;
//            return new ResultVO(0, "添加电影成功", null);
//        } catch (Exception e) {
//            return new ResultVO(1, "添加电影失败", null);
//        }
//
//
//    }


    public ResultVO setscore(String movieName,double movieScore){
//有问题
        co++;
        sc+=movieScore;
        movieScore=sc/co;
        int sco = movieMapper.scoring(movieName,movieScore);

//        try {
//            movieMapper.scoring(movieName,movieScore);
//            return new ResultVO(0, "成功", null);
//        } catch (Exception e) {
//            return new ResultVO(1, "失败", null);
//        }
        if(sco>0){
           return new ResultVO(0,"成功",null);
       }else {
           return new ResultVO(1,"失败",null);
      }
    }

    public ResultVO getAllMovieBaseInfo(){
        List<Movie> movies = movieMapper.getAllMovieBaseInfo();
        return new ResultVO(0,"获取数据成功",movies);
    }

    public ResultVO getMovieInfoById(Integer id){
        if (id!=null) {
            Movie movie = movieMapper.queryMovieInfoById(id);
            if (movie==null) return new ResultVO(1,"数据为null",movie);
            else  return new ResultVO(0,"数据获取成功",movie);
        }
        return new ResultVO(1, "id为空", null);
    }

}

