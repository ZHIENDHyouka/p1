package com.p1.mapper;

import com.p1.entity.Manager;
import com.p1.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper {
    public Manager selectByac(String account);

}
