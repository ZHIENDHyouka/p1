package com.p1.mapper;
import com.p1.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int insertUser(User user);
}
