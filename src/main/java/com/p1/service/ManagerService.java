package com.p1.service;

import com.p1.entity.*;


import com.p1.mapper.ManagerMapper;

import com.p1.mapper.MovieMapper;
import com.p1.mapper.ScheduleMapper;
import com.p1.mapper.UserMapper;
import com.p1.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private MovieMapper movieMapper;


    public ResultVO getAllUser() {
        List<User> userList = userMapper.selectAllUser();
        ResultVO resultVO = new ResultVO(0, "查询成功，共" + userList.size() + "位用户", userList);
        return resultVO;
    }

    public int check(Schedule schedule, Integer movieId, int hallId, String date) {
        //新建排片
        //拿到当前排班的开始时间
        String startTime = schedule.getStartTime();
        int fenstart = Integer.parseInt(startTime.substring(13));//当前电影开始时间
        int shistart = Integer.parseInt(startTime.substring(10, 12));//当前电影开始时间
        int fenend;
        int shiend;
        String endTime1;//前一部电影的结束时间
        String startTime1;//前一部电影的开始时间


        int b = 0;
        int fen1;//结束分钟
        int fen2;//开始分钟
        int shi1;//结束小时
        int shi2;//开始小时


        double shimid;//中间小时

        List<Schedule> schedules = scheduleMapper.selectBy(hallId, date);
        //1是结束  2 是开始
        for (Schedule schedule1 : schedules) {
            startTime1 = schedule1.getStartTime();//拿到每一个开始时间
            endTime1 = schedule1.getEndTime();//拿到每一个结束时间
            fen1 = Integer.parseInt(endTime1.substring(13));//结束时间
            shi1 = Integer.parseInt(endTime1.substring(10, 12));
            fen2 = Integer.parseInt(startTime1.substring(13));//开始时间//开始时间小于结束时间
            shi2 = Integer.parseInt(startTime1.substring(10, 12));
            int time = movieMapper.selectMovieTime(movieId) + 10;

            fenend = fenstart + (time % 60);
            shiend = shistart + (time / 60);

            if (fenend > 60) {
                shiend++;
                fenend = fenend - 60;
            }
            if(shiend>=24){
                return b = 5;
            }

            shimid = (double) (shistart + shiend) / 2;

            if (shi2 < shistart && shistart <= shi1) {//开始时间 有电影放映
                if (fenstart < fen1) {
                    b = 1;
                    return b;
                }
            } else if (shi2 <= shiend && shiend <= shi1) {//结束时间 有电影放映
                if (fenend > fen2) {
                    b = 2;
                    return b;
                }
            } else if (shi2 <= shimid && shimid <= shi1) {//中间时间 有电影放映
                b = 4;
                return b;
            } else {
                b = 3;
            }
        }
        return b;
    }


    public ResultVO saveSchedule(Schedule schedule, Integer movieId, int hallId, String date) {
        String startTime = schedule.getStartTime();
        int time = movieMapper.selectMovieTime(movieId) + 10;
        int fen = Integer.parseInt(startTime.substring(13));
        int shi = Integer.parseInt(startTime.substring(10, 12));
        fen = fen + (time % 60);
        shi = shi + (time / 60);
        if (fen > 60) {
            shi++;
            fen = fen - 60;
        }
        int b = check(schedule, movieId, hallId, date);
        String endTime = date + "-" + shi + ":" + fen;
        //设置新增排片的结束时间

        if (b == 1) {
            return new ResultVO(0, "当前电影[开始]时间该影厅正在放映", null);
        } else if (b == 2) {
            return new ResultVO(0, "当前电影[结束]时间该影厅正在放映", null);
        } else if (b == 3) {
            schedule.setEndTime(endTime);

           schedule.setMovieName(movieMapper.selectById(movieId).getMovieName()) ;
            scheduleMapper.insertSchedule(schedule);

            return new ResultVO(0, "成功", null);
        } else if (b == 4) {
            return new ResultVO(0, "中间时间重复", null);
        } else if(b==5){
            return new ResultVO(0,"别过夜！",null);
        }else {
            return new ResultVO(0, "失败", null);
        }



    }
}
