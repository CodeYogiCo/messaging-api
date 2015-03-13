package com.snapdeal.messaging.model;

import java.util.List;



public class PaginatedUserDetails {
	
	private int current_page;
	
	private int per_page;
	
	private int total_entries;
	
	private List<User>  items;

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal_entries() {
		return total_entries;
	}

	public void setTotal_entries(int total_entries) {
		this.total_entries = total_entries;
	}

	public List<User> getItems() {
		return items;
	}

	public void setItems(List<User> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "PaginatedUserDetails [current_page=" + current_page
				+ ", per_page=" + per_page + ", total_entries=" + total_entries
				+ ", items=" + items + "]";
	}
	
}
