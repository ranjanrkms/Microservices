package com.learning.ecom.serviceImpl;
 import com.learning.ecom.entity.Product;
import com.learning.ecom.repository.ProductRepository;
import com.learning.ecom.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		List<Product> authors = new ArrayList<Product>();
		productRepository.findAll().forEach(authors::add);
		return authors;
	}

	@Override
	public Product getById(long id) {
		Optional<Product> author = productRepository.findById(id);
		
		if(author.isPresent())
			return author.get();

		return null;
	}

	@Override
	public Product create(Product author) {
		return productRepository.save(author);
	}

	@Override
	public Product update(long id, Product author) {
		Optional<Product> updatedAuthor = productRepository.findById(id).map(existingAuthor -> {
			return productRepository.save(author);
			
		});

		if (updatedAuthor.isPresent())
			return updatedAuthor.get();

		return null;
	}

	@Override
	public void delete(long id) {
		productRepository.deleteById(id);
	}

}
