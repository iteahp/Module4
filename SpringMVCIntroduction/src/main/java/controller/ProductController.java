package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {
    ProductService productService = new ProductService();
    RequestDispatcher requestDispatcher;
    @GetMapping("/products")
    public void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",productService.getAllProduct());
        requestDispatcher = request.getRequestDispatcher("/showProducts.jsp");
        requestDispatcher.forward(request,response);
    }
    @GetMapping("/create")
    public void showFormCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        requestDispatcher = request.getRequestDispatcher("/createProduct.jsp");
        requestDispatcher.forward(request,response);
    }
    @PostMapping("/create")
    public void createProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        productService.save(new Product(id,name,img));
        response.sendRedirect("/products");
    }
    @GetMapping("/delete")
    public void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(productService.findIndexById(id));
        response.sendRedirect("/products");
    }
    @GetMapping("/update")
    public void showFormUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getAllProduct().get(productService.findIndexById(id));
        request.setAttribute("product",product);
        requestDispatcher = request.getRequestDispatcher("/updateProduct.jsp");
        requestDispatcher.forward(request,response);

    }
    @PostMapping("/update")
    public void updateProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        productService.update(productService.findIndexById(id),new Product(id,name,img));
        response.sendRedirect("/products");
    }

}
