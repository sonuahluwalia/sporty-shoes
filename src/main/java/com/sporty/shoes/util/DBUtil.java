package com.sporty.shoes.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sporty.shoes.entity.Category;
import com.sporty.shoes.entity.Product;
import com.sporty.shoes.entity.User;
import com.sporty.shoes.repositry.ProductRepository;
import com.sporty.shoes.repositry.UserRepository;
import com.sporty.shoes.security.SecuredPasswordGenerator;

@Configuration
public class DBUtil {
	
	@Autowired
	UserRepository userRepositry;
	
	@Autowired
	ProductRepository productRepositry;
	
	@Bean
	public void onStartup() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword(SecuredPasswordGenerator.securedPassword("admin"));
		user.setCreatedAt(new Date());
		user.setModifiedAt(new Date());
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		userRepositry.save(user);
		System.out.println("admin user saved");

		for(int i = 1; i < 50; i++) {
			Product product = new Product();
			product.setCategory(Category.MISC);
			product.setCost((double) (120+i));
			product.setCreatedAt(new Date());
			product.setDescription("Product Description" + i );
			product.setManufacturerName("Manufacturer Name: " + i);
			product.setModifiedAt(new Date());
			product.setName("Product Name "+ i);
			product.setModel("Model Number "+i);
			productRepositry.save(product);
		}
		
	}
}
