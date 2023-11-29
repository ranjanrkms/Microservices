package com.learning.ecom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.ecom.entity.Product;

import java.util.Optional;

@FeignClient(name = "product-service", url = "http://localhost:8081/api")
public interface ProductClient {
//    @GetMapping(value = "/product", headers = "Authorization=Bearer my_token")
//    String getProduct();

    // Or, you can pass the header value dynamically
    @GetMapping("/products/{id}")
    Optional<Product> getProductById(@PathVariable("id") Long long1);
}
