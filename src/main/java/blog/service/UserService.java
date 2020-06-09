package blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import blog.entity.User;
import blog.repo.UserRepository;

public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByFullName(String fullName) {
		return userRepository.findByFullName(fullName);
	}

}