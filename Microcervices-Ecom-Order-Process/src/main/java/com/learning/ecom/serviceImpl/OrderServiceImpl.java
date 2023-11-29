package com.learning.ecom.serviceImpl;
 import com.learning.ecom.entity.Order;

import com.learning.ecom.entity.Order;
import com.learning.ecom.entity.Product;
import com.learning.ecom.exception.ProductNotFoundException;
import com.learning.ecom.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.ecom.repository.OrderRepository;
import com.learning.ecom.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private ProductClient productClient;
	 
	@Override
	public List<Order> getAll() {
		List<Order> order = new ArrayList<Order>();
		orderRepository.findAll().forEach(order::add);
		return order;
	}

	@Override
	public Order getById(long id) {
		Optional<Order> order = orderRepository.findById(id);
		
		if(order.isPresent())
			return order.get();

		return null;
	}

	@Override
	public Order create(Order order) {
        Optional<Product> optionalProduct = productClient.getProductById(order.getProductId());
        if (optionalProduct.isPresent()) {
            Order ordered = orderRepository.save(order);
            return ordered;
        } else
            throw new ProductNotFoundException("Product NOT found exception");
    }

	@Override
	public Order update(long id, Order order) {
		Optional<Order> updatedOrder = orderRepository.findById(id).map(existingOrder -> {
			return orderRepository.save(order);
			
		});

		if (updatedOrder.isPresent())
			return updatedOrder.get();

		return null;
	}

	@Override
	public void delete(long id) {
		orderRepository.deleteById(id);
	}

}
