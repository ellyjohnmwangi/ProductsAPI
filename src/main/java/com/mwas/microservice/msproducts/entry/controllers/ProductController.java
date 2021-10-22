package com.mwas.microservice.msproducts.entry.controllers;

import com.mwas.microservice.msproducts.models.Product;
import com.mwas.microservice.msproducts.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @PostMapping
    public void newProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam( required = false) String name
//            @RequestParam( required  = false) int price
    ){
        productService.updateProduct(productId, name);
//        productService.updateProduct(productId, name, price);
    }


    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        productService.deleteProduct(id);
    }

}
