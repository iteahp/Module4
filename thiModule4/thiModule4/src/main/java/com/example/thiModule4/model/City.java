package com.example.thiModule4.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    @Min(1)
    private double dienTich;
    @NotBlank
    @Min(1)
    private long danSo;
    @NotBlank
    @Min(1)
    private double GDP;
    @NotBlank
    private String gioiThieu;
    @ManyToOne
    private QuocGia quocGia;
}
