package com.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.app.module.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM ecom.product where model_name=?1",nativeQuery = true)
	List<Product> findByModelName(String modelName);

}
