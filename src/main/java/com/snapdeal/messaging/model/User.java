package com.snapdeal.messaging.model;

import java.io.Serializable;



public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int owner_id;
	
	private String full_name;
	
	private String email;
	
	private String login;
	
	private String created_at;
	
	private int phone;
	
	private String website;
	
	private String updated_at;
	
	private String last_request_at;
	
	private String external_user_id;
	
	private int facebook_id;
	
	private String twitter_id;
	
	private String custom_data;
	
	private String blob_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public String getLast_request_at() {
		return last_request_at;
	}

	public void setLast_request_at(String last_request_at) {
		this.last_request_at = last_request_at;
	}
	
	public String getExternal_user_id() {
		return external_user_id;
	}

	public void setExternal_user_id(String external_user_id) {
		this.external_user_id = external_user_id;
	}
	
	public int getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(int facebook_id) {
		this.facebook_id = facebook_id;
	}
	
	public String getTwitter_id() {
		return twitter_id;
	}

	public void setTwitter_id(String twitter_id) {
		this.twitter_id = twitter_id;
	}
	
	public String getCustom_data() {
		return custom_data;
	}

	public void setCustom_data(String custom_data) {
		this.custom_data = custom_data;
	}
	
	public String getBlob_id() {
		return blob_id;
	}

	public void setBlob_id(String blob_id) {
		this.blob_id = blob_id;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", owner_id=" + owner_id
				+ ", full_name=" + full_name + ", email=" + email + ", login="
				+ login + ", created_at=" + created_at + ", phone=" + phone
				+ ", website=" + website + ", updated_at=" + updated_at
				+ ", last_request_at=" + last_request_at
				+ ", external_user_id=" + external_user_id + ", facebook_id="
				+ facebook_id + ", twitter_id=" + twitter_id + ", custom_data="
				+ custom_data + ", blob_id=" + blob_id + "]";
	}
	
	
	

}
