package com.learning.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.ecom.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
