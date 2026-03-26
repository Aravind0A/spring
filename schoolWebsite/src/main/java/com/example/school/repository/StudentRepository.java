package com.example.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.school.model.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{

	@Query("select s from StudentDetails s where s.name like %:keyword%")
	List<StudentDetails> findByName(@Param("keyword") String keyword);
}
