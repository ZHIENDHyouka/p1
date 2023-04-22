package com.p1.controller;

import com.p1.entity.ResultVO;
import com.p1.entity.User;
import com.p1.mapper.LoginMapper;
import com.p1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    //http://localhost:8083/user/login
    public ResultVO login(@RequestBody User user) {
        String userAccount = user.getUserAccount();
        String loginPwd = user.getUserPwd();
        ResultVO resultVO = loginService.check(userAccount, loginPwd);
        //      成功与否        对象          判断
        return  resultVO;

    }
}
