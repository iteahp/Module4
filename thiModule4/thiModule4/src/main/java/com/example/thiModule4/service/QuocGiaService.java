package com.example.thiModule4.service;

import com.example.thiModule4.model.QuocGia;
import com.example.thiModule4.repo.QuocGiaRePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuocGiaService implements IQuocGiaImpl{
    @Autowired
    QuocGiaRePo quocGiaRePo;
    @Override
    public List<QuocGia> findAll() {
        return (List<QuocGia>) quocGiaRePo.findAll();
    }
}
