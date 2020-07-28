package com.sporty.shoes.repositry;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.shoes.entity.Product;
import com.sporty.shoes.entity.Purchase;
import com.sporty.shoes.entity.User;
 

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
 
//    @Query("SELECT p FROM Purchase p WHERE p.name = :name")
//    public Purchase getPurchaseReportByName(@Param("name") String name);
 
    @Query("select p from Purchase p")
    Page<Purchase> findAllByPage(Pageable pageable);
}