package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{6,15}$",message = "UserName have a-zA-Z0-9 6-15 char")
    private  String userName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$" , message = "PassWord have a-zA-Z0-9 5-15 char")
    private String password;

    @Pattern(regexp = "^[a-zA-Z ]{2,500}$",message = "Full Name 2-500 char")
    private  String fullName;

    @Pattern(regexp =  "^[0-9]{10}$" ,message = " Phone have 10 Number")
    private  String phone;

    @Pattern(regexp = "^\\w*@\\w*\\d*\\S*\\w*$",message = "Email dsad@ass.com")
    private  String email;

    private  String avatar;

    @ManyToOne
    private  Role role;

}
