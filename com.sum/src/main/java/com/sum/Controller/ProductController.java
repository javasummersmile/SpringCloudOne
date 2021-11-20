package com.sum.Controller;

import com.sum.pojo.Product;
import com.sum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/listProducts")
    public String listProducts(Model model){
        List<Product> products = productService.selectAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
}
