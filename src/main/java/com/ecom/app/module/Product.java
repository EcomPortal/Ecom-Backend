package com.ecom.app.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecom.app.dto.ProductDto;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "price")
	private Double price;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "sub_product_id")
	private SubProduct subProductId;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public SubProduct getSubProductId() {
		return subProductId;
	}

	public void setSubProductId(SubProduct subProductId) {
		this.subProductId = subProductId;
	}

	public Product(Long id, String productName, String modelName, Double price, String imageUrl, Boolean isActive,
			SubProduct subProductId) {
		super();
		this.id = id;
		this.productName = productName;
		this.modelName = modelName;
		this.price = price;
		this.imageUrl = imageUrl;
		this.isActive = isActive;
		this.subProductId = subProductId;
	}

	public ProductDto convertToProductDto() {
		return new ProductDto(this.getId(), this.getProductName(), this.getModelName(), this.getPrice(),
				this.getImageUrl(), this.getIsActive(), this.getSubProductId().getId());
	}

}
