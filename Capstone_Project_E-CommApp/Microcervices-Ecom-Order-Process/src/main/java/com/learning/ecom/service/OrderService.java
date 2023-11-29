package com.learning.ecom.service;


import java.util.List;

import com.learning.ecom.entity.Order;



public interface OrderService {

	List<Order> getAll();

	Order getById(long id);

	Order create(Order author);

	Order update(long id, Order author);

	void delete(long id);

}
