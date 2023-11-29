package com.learning.ecom.serviceImpl;
 import com.learning.ecom.entity.User;
import com.learning.ecom.repository.UserRepository;
import com.learning.ecom.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		List<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(user::add);
		return user;
	}

	@Override
	public User getById(long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent())
			return user.get();

		return null;
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(long id, User user) {
		Optional<User> updatedUser = userRepository.findById(id).map(existingUser -> {
			return userRepository.save(user);
			
		});

		if (updatedUser.isPresent())
			return updatedUser.get();

		return null;
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

}
