package com.p1.mapper;

import com.p1.entity.Manager;
import com.p1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    public User selectUserByac(String account);

    public Manager selectManagerByac(String account);

}
