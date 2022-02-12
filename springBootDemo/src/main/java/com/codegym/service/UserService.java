package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements IUserImpl{
    @Autowired
    IUserRepo iUserRepo ;
    @Override
    public List<User> findAll() {
        return (List<User>) iUserRepo.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepo.findAll(pageable);
    }

    @Override
    public void save(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void delete(long id) {
        iUserRepo.deleteById(id);
    }

    @Override
    public User findById(long id) {
        return iUserRepo.findById(id).get();
    }

    @Override
    public List<User> findAllByFullNameContains(String name) {
        return iUserRepo.findAllByFullNameContains(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepo.findByUserName(username);
        System.out.println("đây là user");
        System.out.println(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }
}
