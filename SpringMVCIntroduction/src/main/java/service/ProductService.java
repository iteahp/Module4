package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"iphone12","https://vuatao.vn/wp-content/uploads/2021/09/iphone-13-product-red-select-2021.png"));
        products.add(new Product(2,"iphone13","https://product.hstatic.net/1000340016/product/iphone-12-blue-select-2020_61c50b15ba5a43b890177f66acfacb58.png"));
        products.add(new Product(3,"iphone10","https://inhat.vn/wp-content/uploads/2021/02/cua-hang-iphone-tphcm-2.jpg"));
    }
    public List<Product> getAllProduct(){
        return products;
    }
    public void save(Product product){
        products.add(product);
    }
    public void delete(int index){
        products.remove(index);
    }
    public void update(int index,Product product){
        products.set(index,product);
    }
    public int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
