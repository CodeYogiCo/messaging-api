package com.snapdeal.messaging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.snapdeal.messaging.model.UserDetails;
import com.snapdeal.messaging.service.UserApiService;
import com.wordnik.swagger.annotations.ApiOperation;


@RestController
@EnableSwagger
public class UserApiController {
	@Autowired
	private UserApiService userApiService;
	
	@ApiOperation(value="get user name by identifier ")
	@RequestMapping(value="/user/{userId}" ,method=RequestMethod.GET,
	produces={"text/xml","application/json"})
	
	public List<UserDetails> getUserById(@PathVariable Integer userId){
		return userApiService.getUserById(userId);
	}
	
	
	

}
