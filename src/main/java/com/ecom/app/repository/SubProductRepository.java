package com.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.module.SubProduct;

@Repository
public interface SubProductRepository extends JpaRepository<SubProduct, Long>{

	List<SubProduct> findBySubProductName(String subProductName);

	@Query(value = "select * from sub_product where parent_product_id=?1",nativeQuery = true)
	List<SubProduct> findByParentProductId(Long parentProductId);

}
