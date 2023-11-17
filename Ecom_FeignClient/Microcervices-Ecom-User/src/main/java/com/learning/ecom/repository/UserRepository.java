package com.learning.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
