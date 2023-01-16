package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.module.ParentProduct;

@Repository
public interface ParentProductRepository extends JpaRepository<ParentProduct, Long> {

}
