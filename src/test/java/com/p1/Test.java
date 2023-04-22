package com.p1;

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
    }
}
