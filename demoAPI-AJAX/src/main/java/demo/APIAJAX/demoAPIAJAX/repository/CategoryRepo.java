package demo.APIAJAX.demoAPIAJAX.repository;

import demo.APIAJAX.demoAPIAJAX.model.Category;
import demo.APIAJAX.demoAPIAJAX.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category,Long> {
}
