package com.snapdeal.messaging.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.snapdeal.messaging.model.PaginatedUserDetails;
import com.snapdeal.messaging.model.User;
import com.snapdeal.messaging.service.UserApiService;

@Service
@PropertySource("classpath:userQuery.properties")
public class UserApiServiceImpl implements UserApiService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	@Resource
	private Environment environment;


	public List<User> getUserById(Integer userId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", userId);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryById"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;
	}


	@Override
	public List<User> getUserByTwitterId(String twitterId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("twitter_id", twitterId);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryByTwitterId"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;


		//return getDummyData();
	}

	@Override
	public List<User>  getUserByFacebookId(String facebookId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("facebook_id", facebookId);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryByFacebookId"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;
	}


	@Override
	public List<User> getUserByLoginId(String login) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("login", login);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryByLogin"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;
	}


	@Override
	public List<User> getUserByEmail(String email) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("email", email);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryByEmail"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;
	}


	@Override
	public List<User> getUserByFullName(String full_name) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("full_name", full_name);
		List<User> listOfUserDetails= new ArrayList<User>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryByFullName"), namedParameters,
				new BeanPropertyRowMapper<User>(User.class));
		return listOfUserDetails;
	}


	@Override
	public boolean createUser(User user) {
		boolean status=true;
		try{
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
			namedParameterTemplate.update(environment.getProperty("userInsertQuery"), namedParameters);
		}
		catch(Exception e){
			status=false;
		}
		return status;	
	}


	@Override
	public PaginatedUserDetails getListOfUser() {
		PaginatedUserDetails pud= new PaginatedUserDetails();
		pud.setCurrent_page(1);
		pud.setPer_page(10);
		pud.setTotal_entries(8);
		List<User> listOfItems= new ArrayList<User>();
		listOfItems=jdbcTemplate.query(environment.getProperty("queryForUserList"), 
				new BeanPropertyRowMapper(User.class));
		pud.setItems(listOfItems);
		return pud;
	}


}
