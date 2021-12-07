package com.mwas.microservice.msproducts.entry.controllers;

import com.mwas.microservice.msproducts.models.Product;
import com.mwas.microservice.msproducts.services.ProductService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
//    public Optional<Product> getProduct(@PathVariable("productId")Long id){
//        return productService.findById(id);
//
    @GetMapping
    public ResponseEntity<Object> getProductList(){
        return ResponseEntity
                .ok()
                .body(productService.getProductList());
    }

    @PostMapping
    public ResponseEntity<Object> newProduct(@RequestBody Product product) {
        return ResponseEntity
                .ok()
                .body(productService.addProduct(product));
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody Product product
//            @RequestParam( required  = false) int price
    ){
        return  new ResponseEntity<Product>(productService.updateProduct(productId, product), HttpStatus.OK);
//        productService.updateProduct(productId, product);
//        productService.updateProduct(productId, name, price);
    }


    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        productService.deleteProduct(id);
    }

}