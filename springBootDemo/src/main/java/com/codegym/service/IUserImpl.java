package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserImpl extends UserDetailsService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    void save(User user);
    void delete(long id);
    User findById(long id);
    List<User> findAllByFullNameContains(String name);
}
