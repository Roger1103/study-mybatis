package com.gogoo.dao;

import com.gogoo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void insertUser(User user);

    List<User> getUserList();

    List<User> getUserLike(String value);

    void updateUser(Map<String, Object> map);

    void deleteUser(int id);
}
