package com.p1.controller;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.service.MovieService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
@CrossOrigin//允许来自不同服务器的请求
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    //http://localhost:8083/movie/add
    @RequestMapping("/add")
    public ResultVO add(Movie movie) {
        ResultVO resultVO = movieService.addMovie(movie);
        //      成功与否        对象          判断
        return resultVO;

    }

    //http://localhost:8083/movie/list
    @RequestMapping("/list")
    public ResultVO list() {
        ResultVO resultVO = movieService.getMovie();
        return resultVO;
    }
    //http://localhost:8083/movie/get
    @RequestMapping("/get")
    public ResultVO get( String movieName) {
        ResultVO resultVO = movieService.getByName(movieName);
        return resultVO;
    }
    //http://localhost:8083/movie/getSC
//    @RequestMapping("/getSC")
//    public ResultVO getSC(String movieName){
//        ResultVO resultVO = movieService.getScoreCount(movieName);
//        return resultVO;
//    }

    /**
     * 获取所有电影基本信息
     * @return
     */
    @GetMapping("/getAllMovieBaseInfo")
    public ResultVO getAllMovieBaseInfo(){
        ResultVO allMovieInfo = movieService.getAllMovieBaseInfo();
        return allMovieInfo;
    }

    /**
     * 通过id获取电影信息
     * @param id
     * @return
     */
    @GetMapping("/getMovieInfoById")
    public ResultVO getMovieInfoById(@Param("id") int id){
        ResultVO movieInfo = movieService.getMovieInfoById(id);
        return movieInfo;
    }

}
