package com.spring.boot.springboot.service;

import com.spring.boot.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> all();
    void add(User user);
    User get(int id);
    void delete(int id);
    void edit(User user);
}
