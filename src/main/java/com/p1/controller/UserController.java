package com.p1.controller;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//允许来自不同服务器的请求
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping("/user/add")
    //http://localhost:8083/user/add

    public ResultVO add(User user){
        ResultVO resultVO = userSerivce.saveUser(user);
        return resultVO;
    }


}
