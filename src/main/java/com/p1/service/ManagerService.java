package com.p1.service;

import com.p1.entity.Manager;
import com.p1.entity.Movie;
import com.p1.entity.ResultVO;


import com.p1.mapper.ManagerMapper;

import com.p1.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;




}
