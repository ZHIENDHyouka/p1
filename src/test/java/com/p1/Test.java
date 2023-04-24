package com.p1;

import com.p1.entity.Movie;
import com.p1.entity.User;
import com.p1.mapper.TestMapper;
import com.p1.utils.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private TestMapper testMapper;
    @org.junit.Test
    public void test() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("ds  a");
        user.setUserPwd("@12 1");
        user.setUserAccount("fd sfds");
        System.out.println(user);
        User o = StringUtils.formatObjString(user);
        System.out.println(user);
    }

    public <T> T formatTest(T o) throws IllegalAccessException {
        Class<?> aClass = o.getClass();
        String tarName = "java.lang.String";
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String typeName = fields[i].getType().getTypeName();
            fields[i].setAccessible(true);
            if (tarName.equals(typeName)) {
                fields[i].set(o, StringUtils.stringFormat(fields[i].get(o).toString()));
            }
        }
        return null;
    }
    @org.junit.Test
    public void a(){
        List<Map<String, Object>> maps = testMapper.queryMovie250Info();
        System.out.println(maps);
        String[] strings = {"喜剧", "动漫", "恐怖", "推理", "爱情", "科幻"};
        Movie movie=null;
        for (Map<String,Object> map:
             maps) {
            try {
                String picUrl = map.get("pic_link").toString();
                String name = map.get("cname").toString();
                Double score = (Double) Double.parseDouble(map.get("score").toString());
                String instroduction = map.get("instroduction").toString();
                String info = map.get("info").toString();
                String date  = "2019-12-1";
                Integer movieCA =(int)(Math.random()*10000)+1;
                Integer integer = (int) (Math.random()*strings.length);
                String movieType =  strings[integer];
                String movieLanguage = "中文";
                Integer movieTime=(int) (Math.random()*180);
                int movieOnSale = (int) (Math.random()*80);
                Integer movieSC = 10000;
//                movie = new Movie(null,name, date, score, 10000, movieSC,instroduction, movieType, movieLanguage, movieTime, movieOnSale, movieSC, picUrl, info);
                testMapper.insertMovieInfo(movie);
            } catch (NumberFormatException e) {
                System.out.println(movie);
            }
        }
    }

    @org.junit.Test
    public  void  test01(){
        String startTime ="14:00";
        int fen= Integer.parseInt(startTime.substring(3));
        System.out.println(fen);

    }
}
