package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserImpl {
    List<User> findAll();
    void save(User user);
    void delete(long id);
    User findById(long id);
}
