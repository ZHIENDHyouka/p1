package com.p1.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    @MapKey("id")
    List<Map<String, Object>> queryMovie250Info();

    int insertMovieInfo();

}
