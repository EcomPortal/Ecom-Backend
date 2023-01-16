package com.ecom.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ParentProductDto;
import com.ecom.app.module.ParentProduct;
import com.ecom.app.repository.ParentProductRepository;
import com.ecom.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ParentProductRepository parentProductRepository;
	
	@Override
	public List<ParentProduct> getAllParentProduct() {
		
		return parentProductRepository.findAll();
	}

	@Override
	public ParentProduct saveParentProduct(ParentProductDto parentProduct) {
		ParentProduct product=new ParentProduct();
		product.setImageUrl(parentProduct.getImageUrl());
		product.setProductName(parentProduct.getProductName());
		ParentProduct productObj=parentProductRepository.save(product);
		return productObj;
	}

}
