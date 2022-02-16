package com.example.thiModule4.service;

import com.example.thiModule4.model.City;
import com.example.thiModule4.repo.CityRePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityImpl{
    @Autowired
    CityRePo cityRePo;
    @Override
    public List<City> findAll() {
        return (List<City>) cityRePo.findAll();
    }

    @Override
    public City save(City city) {
         cityRePo.save(city);
         return city;
    }

    @Override
    public void deleteById(long id) {
            cityRePo.deleteById(id);
    }

    @Override
    public City findById(long id) {
        return cityRePo.findById(id).get();
    }
}
