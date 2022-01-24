package demo.APIAJAX.demoAPIAJAX.controller;

import demo.APIAJAX.demoAPIAJAX.model.Category;
import demo.APIAJAX.demoAPIAJAX.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public List<Category> showListCategory(){
        return categoryService.findAll();
    }
}
