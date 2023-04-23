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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    //http://localhost:8083/user/add

    public ResultVO addUser(@RequestBody User user) {//注册
        user = StringUtils.formatObjString(user);
        ResultVO resultVO = userSerivce.saveUser(user);
        return resultVO;
    }

    //http://localhost:8083/user/movieOSList
    @RequestMapping("/movieOSList")
    public ResultVO OSlist() {//查询正在热映电影
        ResultVO resultVO = movieService.getMovieOnSale();
        return resultVO;
    }
    //http://localhost:8083/user/movieOSList
    @RequestMapping("/movieRSList")
    public ResultVO RSlist() {//查询待映推荐
        ResultVO resultVO = movieService.getMovieReadySale();
        return resultVO;
    }

    //http://localhost:8083/user/changeName
    @RequestMapping("/changeName")
    public ResultVO changeName(int userId, String userName) {//修改昵称
        ResultVO resultVO = userSerivce.changeUserName(userId, userName);
        return resultVO;
//http://localhost:8083/user/changePwd
    }

    @RequestMapping("/changePwd")//修改密码
    public ResultVO changePwd(int userId, String userPwd) {
        ResultVO resultVO = userSerivce.changeUserPwd(userId, userPwd);
        return resultVO;

    }
    //http://localhost:8083/user/self
    @RequestMapping("/self")//查看个人信息
    public ResultVO self(int userId) {
        ResultVO resultVO = userSerivce.getByUserId(userId);
        return resultVO;

    }

}
