package demo.APIAJAX.demoAPIAJAX.service;

import demo.APIAJAX.demoAPIAJAX.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductImpl {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    void delete(long id);
     Product save(Product product);
     Product findById(long id);
    List<Product> findAllByNameContains(String nameFind);
}
