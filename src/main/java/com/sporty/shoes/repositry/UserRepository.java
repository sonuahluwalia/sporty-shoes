package com.sporty.shoes.repositry;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.shoes.entity.User;
 
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.name = :name")
    public User getUserByUsername(@Param("name") String name);
    
    @Query("select u from User u")
    Page<User> findAllByPage(Pageable pageable);

}