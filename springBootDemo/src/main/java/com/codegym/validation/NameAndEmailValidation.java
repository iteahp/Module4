package com.codegym.validation;

import com.codegym.model.User;
import com.codegym.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class NameAndEmailValidation implements Validator {
    @Autowired
    IUserRepo iUserRepo;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        List<User> userList = (List<User>) iUserRepo.findAll();

        for (User us: userList) {
            if (us.getUserName().equals(user.getUserName())){
                errors.rejectValue("userName","","UserName already exists");
                break;
            }
        }
        for (User us: userList) {
            if (us.getEmail().equals(user.getEmail())){
                errors.rejectValue("email","","Email already exists");
                break;
            }
        }
    }
}
