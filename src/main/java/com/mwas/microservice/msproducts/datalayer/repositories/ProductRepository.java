package com.mwas.microservice.msproducts.datalayer.repositories;

import com.mwas.microservice.msproducts.models.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository <Product, Long>{

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findProductByName(String name);

}
