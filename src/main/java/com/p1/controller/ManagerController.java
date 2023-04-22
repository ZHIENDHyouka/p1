package com.p1.controller;

import com.p1.entity.Movie;
import com.p1.entity.ResultVO;
import com.p1.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//声明 此类为控制器类，可以接受并响应前端请求的类
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/manager/login")
    //http://localhost:8083/manager/login

    public ResultVO login(String managerAc, String managerPwd) {
        ResultVO resultVO = managerService.check(managerAc, managerPwd);
        //      成功与否        对象          判断
        return  resultVO;

    }

}
