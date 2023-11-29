package com.learning.ecom.service;


import java.util.List;

import com.learning.ecom.entity.User;



public interface UserService {

	List<User> getAll();

	User getById(long id);

	User create(User user);

	User update(long id, User user);

	void delete(long id);

}
