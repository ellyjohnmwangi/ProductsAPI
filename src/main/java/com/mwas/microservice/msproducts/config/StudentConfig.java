package com.mwas.microservice.msproducts.config;


import com.mwas.microservice.msproducts.datalayer.repositories.ProductRepository;
import com.mwas.microservice.msproducts.models.Product;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
   @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
           Product oil =  new Product(
                    "cooking oil",
                    200
            );
            Product soap = new Product(
                    "soap",
                    100
            );
            repository.saveAll(
                    List.of(oil, soap)
            );
        };
    }
}
