package com.ecom.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CartDto;
import com.ecom.app.module.Cart;
import com.ecom.app.repository.CartRepository;
import com.ecom.app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDto saveCartDetails(CartDto cartDto) {
		Cart cartSave = cartDto.convertDtoToCartEntity();
		Cart cartDB = cartRepository.findByUserIdAndProductId(cartDto.getUserId(), cartDto.getProductId().getId());
		Double totalPrice = cartDto.getProductId() != null && cartDto.getProductId().getPrice() != null
				? (cartDto.getProductId().getPrice()) * cartDto.getTotalQuantity()
				: null;
		if (cartDB != null) {
			cartSave.setTotalPrice(cartDB.getTotalPrice() + totalPrice);
			cartSave.setTotalQuantity(cartDB.getTotalQuantity() + cartSave.getTotalQuantity());
			cartSave.setId(cartDB.getId());
		} else {
			cartSave.setTotalPrice(totalPrice);
		}
		CartDto cartDtoResponse = cartRepository.save(cartSave).convertEntityToCartDto();
		return cartDtoResponse;
	}

	@Override
	public List<CartDto> getAllCartDetailsByUser(Long id) {
		List<CartDto> cartDtoResponse = cartRepository.findByUserId(id).stream().map(e -> e.convertEntityToCartDto())
				.toList();
		return cartDtoResponse;
	}

}
