package com.p1.controller;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.service.ManagerService;
import com.p1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private MovieService movieService;

    @RequestMapping("/listUser")
    //http://localhost:8083/manager/listUser
    public ResultVO list() {
        ResultVO resultVO = managerService.getAllUser();
        return resultVO;
    }
    //http://localhost:8083/manager/movieNSList
    @RequestMapping("/movieNSList")
    public ResultVO NSlist() {
        ResultVO resultVO = movieService.getMovieNotSale();
        return resultVO;
    }


}
