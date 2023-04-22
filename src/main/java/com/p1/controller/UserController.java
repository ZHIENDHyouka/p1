package com.p1.controller;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.service.MovieService;
import com.p1.service.UserSerivce;
import com.p1.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //http://localhost:8083/user/add

    public ResultVO add(@RequestBody User user) {
        user = StringUtils.formatObjString(user);
        ResultVO resultVO = userSerivce.saveUser(user);
        return resultVO;
    }
    //http://localhost:8083/user/movieList
    @RequestMapping("/user/movieList")
    public ResultVO list(){
        ResultVO resultVO =movieService.getMovie();
        return  resultVO;
    }



}
