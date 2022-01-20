package com.codegym.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private  String userName;
    private String password;
    private  String fullName;
    private  String phone;
    private  String email;
    private  String avatar;


}
