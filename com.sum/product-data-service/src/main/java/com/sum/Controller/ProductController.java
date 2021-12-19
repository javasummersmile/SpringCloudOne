package com.sum.Controller;

import com.sum.pojo.Product;
import com.sum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping("/products")
    public Object products() {
        List<Product> ps = productService.listProducts();
        return ps;
    }
}
