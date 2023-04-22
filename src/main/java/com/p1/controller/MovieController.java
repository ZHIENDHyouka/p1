package com.p1.controller;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
@CrossOrigin//允许来自不同服务器的请求
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    //http://localhost:8083/movie/add
    @RequestMapping("/add")
    public ResultVO add (Movie movie){
        ResultVO resultVO = movieService.addMovie(movie);
        //      成功与否        对象          判断
        return  resultVO;

    }
    //http://localhost:8083/movie/list
    @RequestMapping("/list")
    public ResultVO list(){
        ResultVO resultVO =movieService.getMovie();
        return  resultVO;
    }

}
