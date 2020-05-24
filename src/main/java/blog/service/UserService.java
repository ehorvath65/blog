package blog.service;

import blog.entity.User;

public interface UserService {
	

	public User findByEmail(String email);
	
	public User findByFullName(String fullName);


}