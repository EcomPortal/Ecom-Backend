package com.ecom.app.dto;

import com.ecom.app.module.Cart;
import com.ecom.app.module.Product;
import com.ecom.app.module.UserData;

public class CartDto {

	private Long id;
	private ProductDto productId;
	private Long userId;
	private Integer totalQuantity;
	private Double totalPrice;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDto getProductId() {
		return productId;
	}

	public void setProductId(ProductDto productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartDto(Long id, ProductDto productId, Long userId, Integer totalQuantity, Double totalPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public Cart convertDtoToCartEntity() {
		return new Cart(this.getId(), this.getProductId().convertToProductEntity(), this.getUserId(), this.getTotalQuantity(),
				this.getTotalPrice());
	}

}
