package com.ecom.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.SubProductAllDetailsDto;
import com.ecom.app.dto.SubProductDto;
import com.ecom.app.module.SubProduct;
import com.ecom.app.repository.SubProductRepository;
import com.ecom.app.service.SubProductService;

@Service
public class SubProductServiceImpl implements SubProductService {

	@Autowired
	private SubProductRepository subProductRepository;

	@Override
	public CustomResponse saveSubProduct(SubProductDto subProductDto) {
		try {
			if (subProductDto != null && subProductDto.getId() == null) {
				List<SubProduct> subProductByName = subProductRepository
						.findBySubProductName(subProductDto.getSubProductName());
				if (subProductByName.size()>0)
					return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null,
							"This Brand name is already exist !!!!");
				SubProduct subProductSave = subProductDto.convertDtoToEntity();
				SubProduct subProductResponse = subProductRepository.save(subProductSave);
				return new CustomResponse(HttpStatus.CREATED.value(), subProductResponse.convertEntityToDto(),
						"Created!!!");
			} else {
				return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, HttpStatus.BAD_REQUEST.name());
			}
		} catch (Exception e) {
			return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
		}
	}

	@Override
	public SubProductAllDetailsDto getAllSubProduct(Long parentProductId) {
		
		List<SubProduct> subProductList = subProductRepository.findByParentProductId(parentProductId);
		List<SubProductDto> subProductDtoList = new ArrayList<>();
		for (SubProduct subProduct : subProductList) {
			subProductDtoList.add(subProduct.convertEntityToDto());
		}
		SubProductAllDetailsDto response = new SubProductAllDetailsDto(subProductList.get(0).getParentProductId().getProductName(),subProductDtoList);
		return response;
	}

}
