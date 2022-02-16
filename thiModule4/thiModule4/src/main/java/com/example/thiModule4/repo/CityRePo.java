package com.example.thiModule4.repo;

import com.example.thiModule4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRePo extends PagingAndSortingRepository<City,Long> {
}
