package com.p1.mapper;

import com.p1.entity.Movie;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    @MapKey("id")
    List<Map<String, Object>> queryMovie250Info();

    int insertMovieInfo(@Param("movie") Movie movie);

}
