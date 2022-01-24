package demo.APIAJAX.demoAPIAJAX.service;

import demo.APIAJAX.demoAPIAJAX.model.Category;
import demo.APIAJAX.demoAPIAJAX.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements  ICategoryImpl{
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();

    }
}
