package demo.APIAJAX.demoAPIAJAX.repository;

import demo.APIAJAX.demoAPIAJAX.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product,Long> {
    List<Product> findAllByNameContains(String nameFind);
}
