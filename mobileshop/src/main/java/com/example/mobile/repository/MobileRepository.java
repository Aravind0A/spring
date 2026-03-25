package com.example.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mobile.model.MobileDetails;

public interface MobileRepository extends JpaRepository<MobileDetails, Integer>{

	@Query("select m.name, m.price from MobileDetails m")
	List<Object[]> findAllMobileNameAndPrice();
	
	@Query("select m from MobileDetails m where m.price < 20000")
	List<MobileDetails> findByPrice();
	
	@Query("select m.type, count(m) from MobileDetails m group by m.type")
	List<Object[]> findByType();
}
