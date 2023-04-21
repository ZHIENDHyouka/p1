package com.p1.controller;

import com.p1.entity.ResultVO;
import com.p1.mapper.LoginMapper;
import com.p1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
@CrossOrigin//允许来自不同服务器的请求
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/user/login")
    //http://localhost:8083/user/login

    public ResultVO login(String userAccount, String loginPwd) {
        ResultVO resultVO = loginService.check(userAccount, loginPwd);
        //      成功与否        对象          判断
        return  resultVO;

    }
}
