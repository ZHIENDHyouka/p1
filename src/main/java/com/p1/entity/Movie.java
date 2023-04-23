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
    private Integer movieId; //电影id
    private String movieName;//电影名字
    private String movieLiveDate;//首映日期
    private Double movieScore;//电影评分
    private Integer movieCA;//关注数量
    private String movieDesc;//电影描述
    private String movieType;//电影类型
    private String movieLanguage;//电影语言
    private Integer movieTime;//电影时长
    private int movieOnSale;//电影售价
    public Integer socreCount;//打分次数
    private String picUrl;//图片地址
    private String actorName;//演员列表


}
