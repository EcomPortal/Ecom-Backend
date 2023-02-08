package com.ecom.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.dto.CartDto;
import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.model.OrderDetails;
import com.ecom.app.service.CartService;
import com.ecom.app.service.EmailServiceVM;
import com.ecom.app.service.OrderDetailsService;
import com.ecom.app.serviceImpl.InvoiceGenerationServiceImpl;

import javassist.expr.NewArray;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	@Autowired
	private InvoiceGenerationServiceImpl invoiceGenerationServiceImpl;

	@PostMapping("add/order")
	public ResponseEntity<?> saveOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
		OrderDetailsDto response = orderDetailsService.saveOrder(orderDetailsDto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("generateinvoce/order/{id}")
	public ResponseEntity<?> genOrderDetails(@PathVariable Long id) throws Exception {
		CustomResponse response = invoiceGenerationServiceImpl.pdfGen(id);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("getAll/order/{userId}")
	public ResponseEntity<?> getAllOrderDetails(@PathVariable Long userId) {
		List<OrderDetailsDto> response = orderDetailsService.getAllOrder(userId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
