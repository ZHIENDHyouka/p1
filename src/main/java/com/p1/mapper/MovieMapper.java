package com.p1.mapper;

import com.p1.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieMapper {
    public int insertMovie(Movie movie);
    public List<Movie> selectMovieList();
    public int selectCount();
}
