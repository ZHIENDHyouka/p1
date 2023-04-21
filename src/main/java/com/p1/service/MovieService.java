package com.p1.service;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;
    public ResultVO addMovie(Movie movie){
        try {
             movieMapper.insertMovie(movie);
             return new ResultVO(0,"添加电影成功",null);
        } catch (Exception e) {
           return new ResultVO(1,"添加电影失败",null);
        }


    }

    public ResultVO getMovie(){
        List<Movie> movieList =movieMapper.selectMovieList();
        int count =movieMapper.selectCount();
        ResultVO resultVO=new ResultVO(0,"查询成功，共"+count+"部电影",movieList);
        return  resultVO;
    }

}

