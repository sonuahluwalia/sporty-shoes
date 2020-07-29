package com.sporty.shoes.service.iface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sporty.shoes.entity.Purchase;
import com.sporty.shoes.util.ReturningValues;

public interface PurchaseService {

	Page<Purchase> getPurchases(Pageable pageable);

	ReturningValues getPurchaseReportByCreatedDate(String createdAt, Pageable pageable);

}
