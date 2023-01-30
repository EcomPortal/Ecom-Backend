package com.ecom.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.model.UserAddressMap;

@Repository
public interface UserAddressMapRepository extends JpaRepository<UserAddressMap, Long> {

}
