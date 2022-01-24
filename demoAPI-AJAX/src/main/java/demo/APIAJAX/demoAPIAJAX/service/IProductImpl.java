package demo.APIAJAX.demoAPIAJAX.service;

import demo.APIAJAX.demoAPIAJAX.model.Product;

import java.util.List;

public interface IProductImpl {
    List<Product> findAll();
    void delete(long id);
     Product save(Product product);
     Product findById(long id);
    List<Product> findAllByNameContains(String nameFind);
}
