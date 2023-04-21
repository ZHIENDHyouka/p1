package com.p1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//存储登录成功与否
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ResultVO {
    //code状态码：0登陆成功 1失败
    //msg提示信息：”账号不存在“
    //data: 数据/null
    private int code;
    private String msg;
    private Object data;


}