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

import com.learning.ecom.entity.User;
import com.learning.ecom.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService productService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	private ResponseEntity<List<User>> getAll() {
		try {
			List<User> users = productService.getAll();

			if (users.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	private ResponseEntity<User> getById(@PathVariable("id") long id) {
		User product = productService.getById(id);
		
		
			return new ResponseEntity<>(product, HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User product) {
		try {
			return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User product) {
		User updated = productService.update(id, product);
			return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			productService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
