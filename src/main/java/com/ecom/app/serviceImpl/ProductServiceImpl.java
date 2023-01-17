package com.ecom.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.module.Product;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.repository.SubProductRepository;
import com.ecom.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SubProductRepository subProductRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		try {
			if (productDto != null && productDto.getId() == null) {
				List<Product> productList = productRepository.findByModelName(productDto.getModelName());
				if (productList.size() > 0)
					throw new RuntimeException("Duplicate ModelName cannot allow!!!");
				Product productSave = productRepository.save(productDto.convertToProductEntity());
				return productSave.convertToProductDto();
			} else {
				throw new RuntimeException("Check you request!!!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ProductDetailsDto getAllProductDetails(Long subProductId) {
		return subProductRepository.findById(subProductId).get().convertToProductDetailsDto();
	}

}
