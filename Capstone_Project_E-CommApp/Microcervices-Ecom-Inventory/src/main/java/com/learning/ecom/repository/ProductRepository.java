package com.learning.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.ecom.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
