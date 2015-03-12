package com.snapdeal.messaging.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.snapdeal.messaging.model.PaginatedUserDetails;
import com.snapdeal.messaging.model.UserDetails;
import com.snapdeal.messaging.service.UserApiService;
@Service
public class UserApiServiceImpl implements UserApiService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<UserDetails> getUserById(Integer userId) {
		return getDummyData();
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
