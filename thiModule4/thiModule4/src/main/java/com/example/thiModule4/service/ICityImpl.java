package com.example.thiModule4.service;

import com.example.thiModule4.model.City;

import java.util.List;

public interface ICityImpl {
    List<City> findAll();
    City save(City city);
    void deleteById(long id);
    City findById(long id);
}
