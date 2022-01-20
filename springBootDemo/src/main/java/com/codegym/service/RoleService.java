package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleImpl{
    @Autowired
    IRoleRepo iRoleRepo;
    @Override
    public List<Role> findAll() {
        return (List<Role>) iRoleRepo.findAll();
    }
}
