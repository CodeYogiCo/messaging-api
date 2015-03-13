package com.snapdeal.messaging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snapdeal.messaging.model.PaginatedUserDetails;
import com.snapdeal.messaging.model.User;
import com.snapdeal.messaging.service.UserApiService;
import com.wordnik.swagger.annotations.ApiOperation;


@RestController

public class UserApiController {
	@Autowired
	private UserApiService userApiService;

	@ApiOperation(value="get user details by identifier ")
	@RequestMapping(value="/user/{userId}" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserById(@PathVariable Integer userId){
		return userApiService.getUserById(userId);
	}

	@ApiOperation(value="get user details by twitter Id ")
	@RequestMapping(value="/users/by_twitter_id" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserByTwitterId(@RequestParam String twitterId){
		return userApiService.getUserByTwitterId(twitterId);
	}
	

	@ApiOperation(value="get user details by facebook Id ")
	@RequestMapping(value="/users/by_facebook_id" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserByFacebookId(@RequestParam String facebookId){
		return userApiService.getUserByFacebookId(facebookId);
	}
	
	@ApiOperation(value="get user details by login")
	@RequestMapping(value="/users/by_login" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserByLoginId(@RequestParam String login){
		return userApiService.getUserByLoginId(login);
	}
	
	@ApiOperation(value="get user details by email")
	@RequestMapping(value="/users/by_email" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserByEmail(@RequestParam String email){
		return userApiService.getUserByEmail(email);
	}
	
	@ApiOperation(value="get user details by full name")
	@RequestMapping(value="/users/by_full_name" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	public List<User> getUserByFullName(@RequestParam String full_name){
		return userApiService.getUserByFullName(full_name);
	}
	
	@ApiOperation(value="user sign up")
	@RequestMapping(value="/users" ,method=RequestMethod.POST)
	public boolean createUser(@RequestBody User user){
		return userApiService.createUser(user);
	}
	
	@ApiOperation(value="Retrieve API Users for current account")
	@RequestMapping(value="/users" ,method=RequestMethod.GET,produces={"text/xml","application/json"})
	public PaginatedUserDetails createUser(){
		return userApiService.getListOfUser();
	}




}
