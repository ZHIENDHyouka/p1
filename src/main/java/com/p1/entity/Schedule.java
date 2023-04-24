package com.p1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Schedule {
    private int scheduleId;
    private int movieId;
    private int hallId;
    private String startTime;
    private String endTime;
    private Double price;
    private String date;
    private String movieName;

}
