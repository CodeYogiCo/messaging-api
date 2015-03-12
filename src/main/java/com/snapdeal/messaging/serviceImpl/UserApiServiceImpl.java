package com.snapdeal.messaging.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.snapdeal.messaging.model.UserDetails;
import com.snapdeal.messaging.service.UserApiService;
@Service
public class UserApiServiceImpl implements UserApiService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<UserDetails> getUserById(Integer userId) {
		return jdbcTemplate.query("select * from user_details",
				new BeanPropertyRowMapper(UserDetails.class) );
	}

}
