package com.sporty.shoes.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.sporty.shoes.ann.ValueOfEnumCategory;
import com.sporty.shoes.entity.Category;

import lombok.Data;

@Data
public class ProductDTO {
	@NotBlank(message = "Product Name is mandatory")
	private String name;
	@Size(min = 5, max = 250, message = "product description should be between 5 and 250 characters")
	private String description;
	private String manufacturerName;
	private String model;
	@Range(min = 0, message = "cost should be greater than or equal to zero")
	private Double cost;
	@ValueOfEnumCategory(enumClass = Category.class)
	private String category;

}
