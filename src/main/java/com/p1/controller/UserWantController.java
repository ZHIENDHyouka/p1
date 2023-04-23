package com.p1.controller;

import com.p1.entity.ResultVO;
import com.p1.entity.UserWant;
import com.p1.service.UserWantService;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userwant")
public class UserWantController {
    @Autowired
    private UserWantService userWantService;

    //http://localhost:8083/userwant/addUW
    @RequestMapping("/addUW")
    public ResultVO addUW(UserWant userWant ,Integer userId,Integer movieId) {

        return userWantService.saveUW(userWant,userId,movieId);

    }

    //http://localhost:8083/userwant/listUW
    @RequestMapping("/listUW")
    public ResultVO listUW(Integer userId) {

        return userWantService.searchUW(userId);

    }

    //http://localhost:8083/userwant/delUW
    @RequestMapping("/delUW")
    public ResultVO delUW(int userId, int movieId) {

        return userWantService.removeUW(userId, movieId);

    }
}
