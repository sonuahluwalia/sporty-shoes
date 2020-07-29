package com.sporty.shoes.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sporty.shoes.entity.Purchase;
import com.sporty.shoes.service.iface.PurchaseService;
import com.sporty.shoes.util.Constants;
import com.sporty.shoes.util.ReturningValues;

@RestController
@RequestMapping("/purchase")
@SuppressWarnings("unchecked")
public class PurchaseRestController {

	@Autowired
	PurchaseService purchaseService;

	@GetMapping(path = "/getPurchases")
	<T> ResponseEntity<T> getPurchasesPage(@RequestParam int page, @RequestParam int size) {
		if (page < 0 || size < 0) {
			return new ResponseEntity<T>((T) Constants.invalidPageAndSize, HttpStatus.BAD_REQUEST);
		} else {
			PageRequest pageRequest = PageRequest.of(page - 1, size);
			return new ResponseEntity<T>((T) purchaseService.getPurchases(pageRequest), HttpStatus.OK);

		}
	}

	@GetMapping(path = "/getPurchaseReportByCreatedDate")
	<T> ResponseEntity<T> getPurchaseReportByCreatedDate(@RequestParam String createdAt, @RequestParam int page,
			@RequestParam int size) {
		if (page < 0 || size < 0) {
			return new ResponseEntity<T>((T) Constants.invalidPageAndSize, HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("Reached Purchased Rest Controller before Service Call");
			PageRequest pageRequest = PageRequest.of(page - 1, size);
			ReturningValues rv = purchaseService.getPurchaseReportByCreatedDate(createdAt, pageRequest);
			System.out.println("THE SIZE OF PAGE IS : " + ((Page<Purchase>) rv.page).getSize());
			if (rv.message == null) {
				return new ResponseEntity<T>((T) ((Page<Purchase>) rv.page), HttpStatus.OK);
			} else {
				return new ResponseEntity<T>((T) rv.message, HttpStatus.BAD_REQUEST);
			}
		}
	}
}
