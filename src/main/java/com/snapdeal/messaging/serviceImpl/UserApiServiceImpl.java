package com.snapdeal.messaging.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.snapdeal.messaging.model.PaginatedUserDetails;
import com.snapdeal.messaging.model.UserDetails;
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


	public List<UserDetails> getUserById(Integer userId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", userId);
		List<UserDetails> listOfUserDetails= new ArrayList<UserDetails>();
		listOfUserDetails= namedParameterTemplate.query(environment.getProperty
				("userQueryById"), namedParameters,
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		return listOfUserDetails;
	}


	@Override
	public UserDetails getUserByTwitterId(Integer twitterId) {
		List <UserDetails> listOfUserDetails=jdbcTemplate.query("select * from user_details",
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class) );
		return listOfUserDetails.get(0);

		//return getDummyData();
	}
	
	public List<PaginatedUserDetails> getPaginatedDetails(Integer userId){
		List<UserDetails> data = getDummyData();
		PaginatedUserDetails pud = new PaginatedUserDetails();
		pud.setCurrent_page(1);
		pud.setItems(data);
		pud.setPer_page(10);
		pud.setTotal_entries(100);
		List<PaginatedUserDetails> pudList = new ArrayList<PaginatedUserDetails>();
		pudList.add(pud);
		return pudList;
	}
	
	
	private List<UserDetails> getDummyData(){
		return jdbcTemplate.query("select * from user_details",
				new BeanPropertyRowMapper(UserDetails.class) );

	}
	

}
