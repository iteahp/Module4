package com.codegym.repository;

import com.codegym.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepo extends PagingAndSortingRepository<Role,Long> {

}
