package com.ecom.app.service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.SubProductDto;

public interface SubProductService {

	CustomResponse saveSubProduct(SubProductDto subProductDto);

	CustomResponse getAllSubProduct(Long parentProductId);

}
