package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.OrderDetailsDto;

public interface OrderDetailsService {

	OrderDetailsDto saveOrder(OrderDetailsDto orderDetailsDto);

	List<OrderDetailsDto> getAllOrder(Long userId);

}
