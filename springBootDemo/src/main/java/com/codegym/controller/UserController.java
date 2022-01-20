package com.codegym.controller;


import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.IRoleImpl;
import com.codegym.service.IUserImpl;
import com.codegym.validation.NameAndEmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserImpl iUser;
    @Autowired
    IRoleImpl iRole;
    @Autowired
    NameAndEmailValidation nameAndEmailValidation;
    @GetMapping("/showUser")
    public ModelAndView showListUser(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/UserManager/showUser");
        modelAndView.addObject("userList",iUser.findAll(PageRequest.of(page,2)));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/UserManager/createUser");
        return modelAndView;
    }
    @PostMapping("create")
    public String create(@Valid  @ModelAttribute(value = "user") User user, BindingResult bindingResult, @RequestParam("upImg")MultipartFile upImg){
        nameAndEmailValidation.validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/UserManager/createUser";
        }
        if (upImg.getSize()!=0){
           String imgFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(),new File("C:\\Users\\MSI\\Desktop\\Module4\\springBootDemo\\src\\main\\resources\\static\\img/" +imgFile));
                user.setAvatar("/img/"+imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            user.setAvatar("/img/alo");
        }
        iUser.save(user);
        return "redirect:/showUser";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam long id){
        iUser.delete(id);
        return "redirect:/showUser";
    }
    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("/UserManager/editUser");
        modelAndView.addObject("user",iUser.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute(value = "user") User user ,BindingResult bindingResult,@RequestParam("upImg")MultipartFile upImg){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/UserManager/editUser");
        }
        if (upImg.getSize()!=0){
            String imgFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(),new File("C:\\Users\\MSI\\Desktop\\Module4\\springBootDemo\\src\\main\\resources\\static\\img/" +imgFile));
                new File("C:\\Users\\MSI\\Desktop\\Module4\\springBootDemo\\src\\main\\resources\\static\\" +user.getAvatar()).delete();
                user.setAvatar("/img/"+imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView modelAndView = new ModelAndView("redirect:showUser");
        iUser.save(user);
        return modelAndView;
    }
    @GetMapping("/seachByFullName")
    public ModelAndView seachByFullName(@RequestParam(value = "nameFind") String nameFind){
        ModelAndView modelAndView = new ModelAndView("/UserManager/showUser");
        modelAndView.addObject("userList",iUser.findAllByFullNameContains(nameFind));
        return modelAndView;
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }
    @ModelAttribute("roleList")
    public List<Role> roleList(){
        return iRole.findAll();
    }
}
