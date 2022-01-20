package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IUserRepo extends PagingAndSortingRepository<User,Long> {
    List<User> findAllByFullNameContains(String name);
}
