package com.p1.mapper;

import com.p1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int insertUser(User user);

    public int updateUserName(int userId, String userName);

    public int updateUserPwd(int userId, String userPwd);

    public  User selectByUserId(int userId);

    public List<User> selectAllUser();

    public int selectCount();
}
