package com.sporty.shoes.dto;

import java.util.Date;

import com.sporty.shoes.entity.Category;

//TODO: do the purchase dto to make full report data available on the rest api
public class PurchaseDTO {
	private Long id;
	private String email;
	private String username;
	private String productname;
	private String productdescription;
	private Double cost;
	private Category category;
	private Date createdAt;
	private Date updatedAt;

	
}
