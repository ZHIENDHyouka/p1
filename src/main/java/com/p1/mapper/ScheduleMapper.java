package com.p1.mapper;

import com.p1.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    public int insertSchedule(Schedule schedule);
    public List<Schedule> selectBy(Integer hallId,String date);

}
