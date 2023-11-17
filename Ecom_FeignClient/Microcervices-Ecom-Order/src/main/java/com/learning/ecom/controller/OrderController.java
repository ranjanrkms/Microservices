package com.learning.ecom.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.ecom.entity.Order;
import com.learning.ecom.exception.BadRequestException;
import com.learning.ecom.exception.InternalServerErrorException;
import com.learning.ecom.exception.ProductNotFoundException;
import com.learning.ecom.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	

	
	 @PostMapping
	    public ResponseEntity<String> createOrder(@RequestBody Order order) {
	        try {
	            Order ordered = orderService.create(order);
	            Long orderedId = ordered.getId();
	            return new ResponseEntity<String>(orderedId.toString(), HttpStatus.OK);
	            
	        } catch (ProductNotFoundException e) {
	            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	        } catch (InternalServerErrorException e) {
	            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	        } catch (BadRequestException e) {
	            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
	@GetMapping
	private ResponseEntity<List<Order>> getAll() {
		try {
			List<Order> orders = orderService.getAll();

			if (orders.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	private ResponseEntity<Order> getById(@PathVariable("id") long id) {
		Order order = orderService.getById(id);
		
		
			return new ResponseEntity<>(order, HttpStatus.OK);
		
	}

	

	@PutMapping("/{id}")
	public ResponseEntity<Order> update(@PathVariable("id") long id, @RequestBody Order order) {
		Order updated = orderService.update(id, order);
			return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			orderService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
