package com.example.thiModule4.controller;

import com.example.thiModule4.model.City;
import com.example.thiModule4.service.ICityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    ICityImpl cityService;
    @GetMapping
    public List<City> showCity(){
        return cityService.findAll();
    }
    @PostMapping
    public City saveCity(@RequestBody City city){
        return cityService.save(city);
    }
    @GetMapping("/{id}")
    public City findById(@PathVariable long id){
        return cityService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        cityService.deleteById(id);
    }
    @PutMapping
    public City editCity(@RequestBody City city){
        return cityService.save(city);
    }
}
