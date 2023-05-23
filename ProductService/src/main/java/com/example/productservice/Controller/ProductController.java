package com.example.productservice.Controller;

import com.example.productservice.Model.Product;
import com.example.productservice.Model.User;
import com.example.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        System.out.println(productService);
        return productService.findAll();
    }

    @PostMapping
    public String addProduct(
            @RequestBody Product product
    ){
        productService.addProduct(product);
        System.out.println("Product added");
        return "Product added";
    }
//
//    @PostMapping("pwithimage")
//    public String productWithImage(
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("product") String product
//            ){
//        System.out.println(file.getOriginalFilename());
//        System.out.println(product);
//        return "true";
//    }
//

}
