package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
