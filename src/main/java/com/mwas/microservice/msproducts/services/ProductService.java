package com.mwas.microservice.msproducts.services;

import com.mwas.microservice.msproducts.datalayer.repositories.ProductRepository;
import com.mwas.microservice.msproducts.models.Product;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
       return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productByName = productRepository.findProductByName(product.getName());
        if(productByName.isPresent()){
            throw new IllegalStateException("name already taken");
        }
        productRepository.save(product);
    }
    public void deleteProduct(Long productId){
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("product with id"+ productId+ "does not exist");
        }
        productRepository.deleteById(productId);
    }
    @Transactional
    public void updateProduct(Long productId,
                              Product product){
//                              int price){
        Product dbProduct = productRepository.findById(productId).orElseThrow(()-> new IllegalStateException(
                "product with id"+ productId + "does not exist"
        ));
        if(product.getName() != null && product.getName().length()> 0 &&
                !Objects.equals(dbProduct.getName(), product.getName())){
            dbProduct.setName(product.getName());
        }
        if(product.getPrice() > 0 && !Objects.equals(dbProduct.getPrice(), product.getPrice())){
            dbProduct.setPrice(product.getPrice());
        }

        productRepository.save(dbProduct);
    }
}
