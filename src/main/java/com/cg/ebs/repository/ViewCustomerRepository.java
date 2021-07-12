package com.cg.ebs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ebs.model.ViewCustomer;

@Repository
public interface ViewCustomerRepository extends JpaRepository<ViewCustomer, String>{
	@Query("select c from ViewCustomer c where c.email=:email")
	ViewCustomer findByEmail(@Param("email") String email);
	
	
	
}
