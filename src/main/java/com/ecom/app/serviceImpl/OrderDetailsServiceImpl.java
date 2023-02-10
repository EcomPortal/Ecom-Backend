package com.ecom.app.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.model.Cart;
import com.ecom.app.model.OrderDetails;
import com.ecom.app.repository.CartRepository;
import com.ecom.app.repository.OrderDetailsRepository;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.service.OrderDetailsService;
import com.ecom.app.util.GenerateRandomCode;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private InvoiceGenerationServiceImpl invoiceGenerationServiceImpl;

	@Transactional
	@Override
	public OrderDetailsDto saveOrder(OrderDetailsDto orderDetailsDto) {
		if (orderDetailsDto.getUserId() == null || orderDetailsDto.getUserId() == 0) {
			throw new RuntimeException("Please provide valid user!!!");
		}
		if (orderDetailsDto.getProductId() == null || orderDetailsDto.getProductId() == 0) {
			throw new RuntimeException("Please provide valid product!!!");
		}
		if (orderDetailsDto.getAddressId() == null || orderDetailsDto.getAddressId() == 0) {
			throw new RuntimeException("Please provide valid address!!!");
		}
		OrderDetails orderDetailsSave = orderDetailsDto.convertToOrderDetails();
		orderDetailsSave.setUuid(GenerateRandomCode.randomString(12).toUpperCase());
		orderDetailsSave.setCreatedOn(new Date());
		OrderDetailsDto orderDetailsResponse = orderDetailsRepository.save(orderDetailsSave).convertToOrderDetailsDto();
		if (orderDetailsResponse != null && orderDetailsResponse.getId() != null) {
			productRepository.updateAvailableStock(orderDetailsDto.getProductId());
		}
		Cart cartDetails = cartRepository.findByUserIdAndProductId(orderDetailsDto.getUserId(),
				orderDetailsDto.getProductId());
		if (cartDetails != null && cartDetails.getId() != null) {
			cartRepository.deleteById(cartDetails.getId());
		}
		
		return orderDetailsResponse;
	}

	@Override
	public List<OrderDetailsDto> getAllOrder(Long userId) {
		List<OrderDetails> orderDetailList = orderDetailsRepository.findAllByUserId(userId);
		List<OrderDetailsDto> orderDetailsResponse = orderDetailList.stream().map(e -> e.convertToOrderDetailsDtoV2())
				.collect(Collectors.toList());
		return orderDetailsResponse;
	}

	
	
}
