package demo.APIAJAX.demoAPIAJAX.service;

import demo.APIAJAX.demoAPIAJAX.model.Product;
import demo.APIAJAX.demoAPIAJAX.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductImpl{
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }


    @Override
    public void delete(long id) {
            productRepo.deleteById(id);
    }

    @Override
    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public Product findById(long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> findAllByNameContains(String nameFind) {
        return productRepo.findAllByNameContains(nameFind);
    }
}
