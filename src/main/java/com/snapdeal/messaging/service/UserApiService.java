package com.snapdeal.messaging.service;

import java.util.List;

import com.snapdeal.messaging.model.PaginatedUserDetails;
import com.snapdeal.messaging.model.User;

public interface UserApiService {
	
	
	public List<User> getUserById(Integer userId);

	public List<User> getUserByTwitterId(String twitterId);

	public List<User> getUserByFacebookId(String facebookId);

	public List<User> getUserByLoginId(String login);

	public List<User> getUserByEmail(String email);

	public List<User> getUserByFullName(String full_name);

	public boolean createUser(User user);

	public PaginatedUserDetails getListOfUser();

}
