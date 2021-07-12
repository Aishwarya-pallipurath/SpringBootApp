package com.cg.ebs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ebs.model.BillUnit;

@Repository
public interface BillUnitRepository extends JpaRepository<BillUnit, String>{

	
	
	@Query("select c from BillUnit c where c.email=:email")
	Optional<BillUnit> findByEmail(@Param("email") String email);
	


}
