package demo.APIAJAX.demoAPIAJAX.controller;
import demo.APIAJAX.demoAPIAJAX.model.Product;
import demo.APIAJAX.demoAPIAJAX.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> showListProduct(){
        return productService.findAll();
    }

//    @GetMapping
//    public Page<Product> showListProduct(@RequestParam(defaultValue = "0") int page){
//        return productService.findAll(PageRequest.of(page,2));
//    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        productService.delete(id);
    }

    @PutMapping()
    public ResponseEntity<Product> edit(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
    }

    @GetMapping("/search/{nameFind}")
    public ResponseEntity<List<Product>> findAllByName(@PathVariable String nameFind){
        return new ResponseEntity<>(productService.findAllByNameContains(nameFind),HttpStatus.OK);
    }


}
