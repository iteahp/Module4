package com.example.thiModule4.controller;

import com.example.thiModule4.model.QuocGia;
import com.example.thiModule4.service.IQuocGiaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quocgia")
public class QuocGiaController {
    @Autowired
    IQuocGiaImpl iQuocGia;
    @GetMapping
    public List<QuocGia> showQuocGia(){
        return iQuocGia.findAll();
    }
}
