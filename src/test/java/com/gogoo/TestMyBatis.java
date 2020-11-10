package com.gogoo;

import com.gogoo.dao.UserMapper;
import com.gogoo.pojo.User;
import com.gogoo.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void TestInsertUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insertUser(new User(1, "luo", "1230990"));
        session.commit();

        session.close();
    }

    @Test
    public void TestUserList() {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserList();
        System.out.println(Arrays.toString(users.toArray()));

        session.close();
    }

    @Test
    public void TestUserLike() {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserLike("%l%");
        System.out.println(Arrays.toString(users.toArray()));

        session.close();
    }

    @Test
    public void TestUpdateUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("pwd", "000000");
        userMapper.updateUser(map);
        session.commit();

        session.close();
    }

    @Test
    public void TestDeleteUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        userMapper.deleteUser(2);
        session.commit();

        session.close();
    }
}
