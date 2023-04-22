package com.p1.mapper;

import com.p1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public int insertUser(User user);

    public int updateUserName(@Param("userId") int userId, @Param("userName")String userName);

    public int updateUserPwd(@Param("userId") int userId,  @Param("userName") String userPwd);

    public  User selectByUserId(int userId);

    public List<User> selectAllUser();

    public int selectCount();
}
