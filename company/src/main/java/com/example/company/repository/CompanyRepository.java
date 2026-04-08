package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.company.model.CompanyDetails;

public interface CompanyRepository extends JpaRepository<CompanyDetails, Long>{

    @Query("SELECT c FROM CompanyDetails c WHERE c.name LIKE %:keyword%")
	List<CompanyDetails> findAllByKeyword(@Param("keyword") String keyword);
	
}
