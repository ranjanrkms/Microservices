package com.learning.ecom.service;


import java.util.List;

import com.learning.ecom.entity.Product;



public interface ProductService {

	List<Product> getAll();

	Product getById(long id);

	Product create(Product author);

	Product update(long id, Product author);

	void delete(long id);

}
