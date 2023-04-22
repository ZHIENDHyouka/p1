package com.p1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    private Integer movieId;
    private String movieName;
    private String movieLiveDate;//首映日期
    private Double movieScore;
    private Integer movieCA;//关注数量
    private String movieDesc;
    private String movieType;
    private String movieLanguage;
    private Integer movieTime;//电影时长
    private int movieOnSale;
    private int movieSC;

}
