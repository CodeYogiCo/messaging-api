package com.snapdeal.messaging.service;

import java.util.List;

import com.snapdeal.messaging.model.UserDetails;

public interface UserApiService {
	
	
	public List<UserDetails> getUserById(Integer userId);

	public List<UserDetails> getUserByTwitterId(String twitterId);

	public List<UserDetails> getUserByFacebookId(String facebookId);

}
