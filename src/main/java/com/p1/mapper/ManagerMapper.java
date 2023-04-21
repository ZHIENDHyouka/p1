package com.p1.mapper;

import com.p1.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
    public Manager selectByac(String account);
}
