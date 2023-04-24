package com.p1.service;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.entity.UserMovieScore;
import com.p1.mapper.MovieMapper;
import com.p1.mapper.UserMovieScoreInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private UserMovieScoreInfoMapper userMovieScoreInfoMapper;

    public ResultVO addMovie(Movie movie) {
        try {
            movieMapper.insertMovie(movie);
            return new ResultVO(0, "添加电影成功", null);
        } catch (Exception e) {
            return new ResultVO(1, "添加电影失败", null);
        }
    }

    public ResultVO getMovieOnSale() {
        List<Movie> movieList = movieMapper.selectMovieOSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影正在热映", movieList);
        return resultVO;
    }

    public ResultVO getMovieReadySale() {
        List<Movie> movieList = movieMapper.selectMovieRSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影即将上映", movieList);
        return resultVO;
    }

    public ResultVO getMovieNotSale() {
        List<Movie> movieList = movieMapper.selectMovieNSList();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + movieList.size() + "部电影已经下架", movieList);
        return resultVO;
    }

    public ResultVO getByName(String movieName) {
        Movie movie = movieMapper.selectByName(movieName);
        ResultVO resultVO = new ResultVO(0, "成功", movie);
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

    public ResultVO getAllMovieBaseInfo() {
        List<Movie> movies = movieMapper.getAllMovieBaseInfo();
        return new ResultVO(0, "获取数据成功", movies);
    }

    public ResultVO getMovieInfoById(Integer id) {
        if (id != null) {
            Movie movie = movieMapper.queryMovieInfoById(id);
            if (movie == null) return new ResultVO(1, "数据为null", movie);
            else return new ResultVO(0, "数据获取成功", movie);
        }
        return new ResultVO(1, "id为空", null);
    }
    public ResultVO setOnSale(Integer movieId){
        if (movieMapper.selectSale(movieId)!=1){
            movieMapper.OnSale(movieId);
            return new ResultVO(0,"成功",null);
        }else {
            return new ResultVO(1,"已经上架",null);
        }


    }
    public ResultVO setNotSale(Integer movieId){
        if (movieMapper.selectSale(movieId)!=2){
            movieMapper.NotSale(movieId);
            return new ResultVO(0,"成功",null);
        }else {
            return new ResultVO(1,"已经下架",null);
        }


    }
//    public ResultVO getMovieTime(Integer movieId){
//        int time = movieMapper.selectMovieTime(movieId);
//        return new ResultVO(0,"获取数据成功",time);
//    }

    public ResultVO userMovieScore(UserMovieScore data) {
        UserMovieScore userMovieScore = userMovieScoreInfoMapper.queryUserScoreMovie(data.getUserId(), data.getMovieId());
        Movie movie = movieMapper.queryMovieInfoById(data.getMovieId());
        Integer count = null;
        Double average = null;
        if (userMovieScore == null) {
            //第一次评分
            userMovieScoreInfoMapper.insertUserMovieScore(data);//插入评分信息
            count = movie.getSocreCount() + 1;
            average = (movie.getMovieScore() * movie.getSocreCount() + data.getMovieScore()) / count;
        } else {
            //多次评分
            count = movie.getSocreCount();
            average = (movie.getMovieScore() * movie.getSocreCount() - userMovieScore.getMovieScore() + data.getMovieScore()) / count;
            userMovieScoreInfoMapper.updateUserMovieScore(data);//更新之前信息
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        double v = Double.parseDouble(decimalFormat.format(average));
        int i = movieMapper.updateMovieScore(v, count, data.getMovieId());
        if (i > 0) return new ResultVO(0, "评分成功!", null);
        else return new ResultVO(1, "评分失败!", null);
    }

    public ResultVO getUserMovieScore(UserMovieScore userMovieScore) {
        UserMovieScore result = userMovieScoreInfoMapper.queryUserScoreMovie(userMovieScore.getUserId(), userMovieScore.getMovieId());
        if (result!=null) return new ResultVO(0, "", result.getMovieScore());
        else return new ResultVO(1, "", null);

    }

}

