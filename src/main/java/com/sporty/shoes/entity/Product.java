package com.sporty.shoes.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	private String name;
	private String description;
	private Date createdAt;
	private Date modifiedAt;
	private String manufacturerName;
	private String model;
	private Double cost;
	private Category category;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
	private Purchase purchase;

}
